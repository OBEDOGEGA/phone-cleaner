package com.smartphonecleaner.pro.data.repository

import android.content.Context
import android.content.pm.PackageManager
import android.os.Environment
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.smartphonecleaner.pro.data.local.CleaningHistory
import com.smartphonecleaner.pro.data.local.CleaningHistoryDao
import com.smartphonecleaner.pro.data.worker.ScheduledCleaningWorker
import com.smartphonecleaner.pro.domain.model.JunkItem
import com.smartphonecleaner.pro.domain.model.JunkType
import com.smartphonecleaner.pro.domain.repository.ICleanRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CleanRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val cleaningHistoryDao: CleaningHistoryDao
) : ICleanRepository {

    override fun scanForJunk(): Flow<List<JunkItem>> = flow {
        val junkItems = mutableListOf<JunkItem>()

        // Check MANAGE_EXTERNAL_STORAGE permission for Android 11+
        val hasManageStorage = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            android.os.Environment.isExternalStorageManager()
        } else {
            true
        }
        android.util.Log.d("CleanRepositoryImpl", "MANAGE_EXTERNAL_STORAGE granted: $hasManageStorage")

        if (!hasManageStorage) {
            android.util.Log.w("CleanRepositoryImpl", "MANAGE_EXTERNAL_STORAGE not granted, scanning may fail")
        }

        // Scan cache files
        junkItems.addAll(scanCacheFiles())

        // Scan residual files
        junkItems.addAll(scanResidualFiles())

        // Scan APK files
        junkItems.addAll(scanApkFiles())

        // Scan empty folders
        junkItems.addAll(scanEmptyFolders())

        // Scan thumbnail cache
        junkItems.addAll(scanThumbnailCache())

        emit(junkItems)
    }

    override suspend fun cleanJunk(items: List<JunkItem>): Long = withContext(Dispatchers.IO) {
        var totalCleanedSize = 0L
        val startTime = System.currentTimeMillis()

        items.filter { it.isSelected }.forEach { item ->
            try {
                if (item.file.exists()) {
                    when (item.type) {
                        JunkType.EMPTY_FOLDER -> {
                            if (item.file.isDirectory && item.file.listFiles()?.isEmpty() == true) {
                                item.file.delete()
                                totalCleanedSize += item.size
                            }
                        }
                        else -> {
                            if (item.file.isFile) {
                                val size = item.file.length()
                                item.file.delete()
                                totalCleanedSize += size
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                // Log error but continue with other files
                e.printStackTrace()
            }
        }

        // Save cleaning history
        val duration = System.currentTimeMillis() - startTime
        val cleanedItems = items.count { it.isSelected }
        val history = CleaningHistory(
            timestamp = System.currentTimeMillis(),
            cleanedSize = totalCleanedSize,
            cleanedItems = cleanedItems,
            duration = duration
        )
        cleaningHistoryDao.insert(history)

        totalCleanedSize
    }

    override suspend fun getTotalJunkSize(): Long = withContext(Dispatchers.IO) {
        var totalSize = 0L

        try {
            // Calculate total size of all junk items
            scanCacheFiles().forEach { totalSize += it.size }
            scanResidualFiles().forEach { totalSize += it.size }
            scanApkFiles().forEach { totalSize += it.size }
            scanEmptyFolders().forEach { totalSize += it.size }
            scanThumbnailCache().forEach { totalSize += it.size }
            android.util.Log.d("CleanRepositoryImpl", "Total junk size calculated: $totalSize bytes")
        } catch (e: Exception) {
            android.util.Log.e("CleanRepositoryImpl", "Error calculating total junk size", e)
        }

        totalSize
    }

    private suspend fun scanCacheFiles(): List<JunkItem> = withContext(Dispatchers.IO) {
        val cacheItems = mutableListOf<JunkItem>()

        try {
            val externalCacheDir = context.externalCacheDir
            externalCacheDir?.let { cacheDir ->
                scanDirectory(cacheDir, JunkType.CACHE, "Cache Files")?.let { cacheItems.addAll(it) }
            }

            // Scan app-specific cache directories
            val packageManager = context.packageManager
            val installedPackages = packageManager.getInstalledPackages(PackageManager.GET_META_DATA)

            installedPackages.forEach { packageInfo ->
                try {
                    val appCacheDir = context.getExternalFilesDir(null)?.parentFile?.let { externalDir ->
                        File(externalDir, "${packageInfo.packageName}/cache")
                    }
                    appCacheDir?.let { cacheDir ->
                        if (cacheDir.exists()) {
                            scanDirectory(cacheDir, JunkType.CACHE, "${packageInfo.applicationInfo?.loadLabel(packageManager) ?: "App"} Cache")
                                ?.let { cacheItems.addAll(it) }
                        }
                    }
                } catch (e: Exception) {
                    // Skip inaccessible app cache
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        cacheItems
    }

    private suspend fun scanResidualFiles(): List<JunkItem> = withContext(Dispatchers.IO) {
        val residualItems = mutableListOf<JunkItem>()

        try {
            val externalStorage = Environment.getExternalStorageDirectory()
            scanDirectoryForExtensions(
                externalStorage,
                listOf(".temp", ".log", ".cache", ".tmp", ".bak"),
                JunkType.RESIDUAL,
                "Residual Files"
            )?.let { residualItems.addAll(it) }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        residualItems
    }

    private suspend fun scanApkFiles(): List<JunkItem> = withContext(Dispatchers.IO) {
        val apkItems = mutableListOf<JunkItem>()

        try {
            val externalStorage = Environment.getExternalStorageDirectory()
            scanDirectoryForExtensions(
                externalStorage,
                listOf(".apk"),
                JunkType.APK,
                "APK Files"
            )?.let { apkItems.addAll(it) }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        apkItems
    }

    private suspend fun scanEmptyFolders(): List<JunkItem> = withContext(Dispatchers.IO) {
        val emptyFolders = mutableListOf<JunkItem>()

        try {
            val externalStorage = Environment.getExternalStorageDirectory()
            scanForEmptyDirectories(externalStorage, "Empty Folders")?.let { emptyFolders.addAll(it) }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        emptyFolders
    }

    private suspend fun scanThumbnailCache(): List<JunkItem> = withContext(Dispatchers.IO) {
        val thumbnailItems = mutableListOf<JunkItem>()

        try {
            // Common thumbnail cache locations
            val thumbnailDirs = listOf(
                File(Environment.getExternalStorageDirectory(), ".thumbnails"),
                File(Environment.getExternalStorageDirectory(), "DCIM/.thumbnails"),
                File(context.cacheDir, "thumbnails")
            )

            thumbnailDirs.forEach { dir ->
                if (dir.exists()) {
                    scanDirectory(dir, JunkType.THUMBNAIL, "Thumbnail Cache")?.let { thumbnailItems.addAll(it) }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        thumbnailItems
    }

    private suspend fun scanDirectory(dir: File, type: JunkType, category: String): List<JunkItem>? = withContext(Dispatchers.IO) {
        if (!dir.exists() || !dir.canRead()) return@withContext null

        val items = mutableListOf<JunkItem>()
        val files = dir.listFiles() ?: return@withContext null

        for (file in files) {
            if (file.isFile && file.canRead()) {
                items.add(JunkItem(file, file.length(), type, category))
            } else if (file.isDirectory && file.canRead()) {
                // Recursively scan subdirectories
                scanDirectory(file, type, category)?.let { items.addAll(it) }
            }
        }

        items
    }

    private suspend fun scanDirectoryForExtensions(
        dir: File,
        extensions: List<String>,
        type: JunkType,
        category: String
    ): List<JunkItem>? = withContext(Dispatchers.IO) {
        if (!dir.exists() || !dir.canRead()) return@withContext null

        val items = mutableListOf<JunkItem>()
        val files = dir.listFiles() ?: return@withContext null

        for (file in files) {
            if (file.isFile && file.canRead()) {
                val fileName = file.name.lowercase()
                if (extensions.any { fileName.endsWith(it) }) {
                    items.add(JunkItem(file, file.length(), type, category))
                }
            } else if (file.isDirectory && file.canRead()) {
                // Recursively scan subdirectories
                scanDirectoryForExtensions(file, extensions, type, category)?.let { items.addAll(it) }
            }
        }

        items
    }

    private suspend fun scanForEmptyDirectories(dir: File, category: String): List<JunkItem>? = withContext(Dispatchers.IO) {
        if (!dir.exists() || !dir.canRead()) return@withContext null

        val items = mutableListOf<JunkItem>()
        val files = dir.listFiles() ?: return@withContext null

        for (file in files) {
            if (file.isDirectory && file.canRead()) {
                val subFiles = file.listFiles()
                if (subFiles != null && subFiles.isEmpty()) {
                    // Empty directory
                    items.add(JunkItem(file, 0L, JunkType.EMPTY_FOLDER, category))
                } else {
                    // Recursively check subdirectories
                    scanForEmptyDirectories(file, category)?.let { items.addAll(it) }
                }
            }
        }

        items
    }

    override suspend fun scheduleAutoClean(intervalHours: Int) {
        val workRequest = PeriodicWorkRequestBuilder<ScheduledCleaningWorker>(intervalHours.toLong(), TimeUnit.HOURS)
            .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "auto_clean",
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequest
        )
    }

    override suspend fun cancelAutoClean() {
        WorkManager.getInstance(context).cancelUniqueWork("auto_clean")
    }
}