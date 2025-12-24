package com.smartcleaner.pro.data.repository

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.pm.PackageInfoCompat
import com.smartcleaner.pro.domain.model.AppInfo
import com.smartcleaner.pro.domain.model.DuplicateFile
import com.smartcleaner.pro.domain.model.LargeFile
import com.smartcleaner.pro.domain.repository.IAnalyzeRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.io.File
import java.security.MessageDigest
import javax.inject.Inject

class AnalyzeRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : IAnalyzeRepository {

    private val packageManager: PackageManager = context.packageManager

    override fun getInstalledApps(): Flow<List<AppInfo>> = flow {
        val apps = withContext(Dispatchers.IO) {
            val installedPackages = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                packageManager.getInstalledPackages(PackageManager.PackageInfoFlags.of(PackageManager.GET_PERMISSIONS.toLong()))
            } else {
                @Suppress("DEPRECATION")
                packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS)
            }

            installedPackages.mapNotNull { packageInfo ->
                createAppInfo(packageInfo)
            }
        }
        emit(apps)
    }.flowOn(Dispatchers.IO)

    override suspend fun getAppDetails(packageName: String): AppInfo? = withContext(Dispatchers.IO) {
        try {
            val packageInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(PackageManager.GET_PERMISSIONS.toLong()))
            } else {
                @Suppress("DEPRECATION")
                packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS)
            }
            createAppInfo(packageInfo)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }
    }

    override suspend fun uninstallApp(packageName: String): Boolean = withContext(Dispatchers.IO) {
        try {
            val intent = android.content.Intent(android.content.Intent.ACTION_DELETE)
            intent.data = android.net.Uri.parse("package:$packageName")
            intent.flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
            true // Assume success as we can't get direct feedback
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun moveAppToSdCard(packageName: String): Boolean = withContext(Dispatchers.IO) {
        try {
            val intent = android.content.Intent(android.content.Intent.ACTION_MANAGE_PACKAGE_STORAGE)
            intent.data = android.net.Uri.parse("package:$packageName")
            intent.flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun isSdCardAvailable(): Boolean = withContext(Dispatchers.IO) {
        // Check if external storage is available
        val externalStorageState = android.os.Environment.getExternalStorageState()
        externalStorageState == android.os.Environment.MEDIA_MOUNTED
    }

    private fun createAppInfo(packageInfo: PackageInfo): AppInfo? {
        return try {
            val applicationInfo = packageInfo.applicationInfo ?: return null
            val appName = packageManager.getApplicationLabel(applicationInfo).toString()
            val icon = packageManager.getApplicationIcon(applicationInfo)

            val size = getAppSize(packageInfo)
            val permissions = packageInfo.requestedPermissions?.toList() ?: emptyList()

            AppInfo(
                packageName = packageInfo.packageName,
                appName = appName,
                versionName = packageInfo.versionName ?: "Unknown",
                versionCode = PackageInfoCompat.getLongVersionCode(packageInfo),
                size = size,
                lastUpdateTime = packageInfo.lastUpdateTime,
                firstInstallTime = packageInfo.firstInstallTime,
                isSystemApp = (applicationInfo.flags and android.content.pm.ApplicationInfo.FLAG_SYSTEM) != 0,
                icon = icon,
                permissions = permissions,
                storageUsed = size
            )
        } catch (e: Exception) {
            null
        }
    }

    private fun getAppSize(packageInfo: PackageInfo): Long {
        return try {
            val applicationInfo = packageInfo.applicationInfo
            val file = java.io.File(applicationInfo.sourceDir)
            file.length()
        } catch (e: Exception) {
            0L
        }
    }

    override suspend fun findDuplicateFiles(): List<DuplicateFile> = withContext(Dispatchers.IO) {
        val allFiles = mutableListOf<File>()
        val directories = listOf(
            context.getExternalFilesDir(null)?.parentFile?.parentFile?.parentFile, // External storage
            context.filesDir.parentFile // Internal storage
        ).filterNotNull()

        // Recursively collect all files
        fun collectFiles(dir: File) {
            if (dir.exists() && dir.canRead()) {
                dir.listFiles()?.forEach { file ->
                    if (file.isDirectory && !file.name.startsWith(".")) {
                        collectFiles(file)
                    } else if (file.isFile && file.canRead() && file.length() > 0) {
                        allFiles.add(file)
                    }
                }
            }
        }

        directories.forEach { collectFiles(it) }

        // Group files by MD5 hash
        val hashGroups = mutableMapOf<String, MutableList<File>>()
        allFiles.forEach { file ->
            try {
                val hash = calculateMD5(file)
                hashGroups.getOrPut(hash) { mutableListOf() }.add(file)
            } catch (e: Exception) {
                // Skip files that can't be hashed
            }
        }

        // Create DuplicateFile objects for groups with more than one file
        return@withContext hashGroups.values
            .filter { it.size > 1 }
            .map { files ->
                val representativeFile = files.first()
                DuplicateFile(
                    file = representativeFile,
                    size = representativeFile.length(),
                    md5Hash = calculateMD5(representativeFile),
                    duplicateGroup = files
                )
            }
    }

    override suspend fun findLargeFiles(minSizeBytes: Long): List<LargeFile> = withContext(Dispatchers.IO) {
        val largeFiles = mutableListOf<LargeFile>()
        val directories = listOf(
            context.getExternalFilesDir(null)?.parentFile?.parentFile?.parentFile,
            context.filesDir.parentFile
        ).filterNotNull()

        fun scanForLargeFiles(dir: File) {
            if (dir.exists() && dir.canRead()) {
                dir.listFiles()?.forEach { file ->
                    if (file.isDirectory && !file.name.startsWith(".")) {
                        scanForLargeFiles(file)
                    } else if (file.isFile && file.canRead() && file.length() >= minSizeBytes) {
                        val fileType = getFileExtension(file.name)
                        largeFiles.add(
                            LargeFile(
                                file = file,
                                size = file.length(),
                                lastModified = file.lastModified(),
                                fileType = fileType
                            )
                        )
                    }
                }
            }
        }

        directories.forEach { scanForLargeFiles(it) }

        // Sort by size descending
        return@withContext largeFiles.sortedByDescending { it.size }
    }

    private fun calculateMD5(file: File): String {
        val digest = MessageDigest.getInstance("MD5")
        file.inputStream().use { input ->
            val buffer = ByteArray(8192)
            var bytesRead: Int
            while (input.read(buffer).also { bytesRead = it } != -1) {
                digest.update(buffer, 0, bytesRead)
            }
        }
        return digest.digest().joinToString("") { "%02x".format(it) }
    }

    private fun getFileExtension(fileName: String): String {
        val lastDotIndex = fileName.lastIndexOf('.')
        return if (lastDotIndex > 0 && lastDotIndex < fileName.length - 1) {
            fileName.substring(lastDotIndex + 1).lowercase()
        } else {
            "unknown"
        }
    }
}