package com.smartcleaner.pro.data.repository

import android.app.ActivityManager
import android.content.Context
import android.content.SharedPreferences
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.smartcleaner.pro.data.worker.MemoryBoostWorker
import com.smartcleaner.pro.data.local.WhitelistedApp
import com.smartcleaner.pro.data.local.WhitelistedAppDao
import com.smartcleaner.pro.domain.model.RunningApp
import com.smartcleaner.pro.domain.repository.IBoostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BoostRepositoryImpl @Inject constructor(
    private val context: Context,
    private val sharedPreferences: SharedPreferences,
    private val whitelistedAppDao: WhitelistedAppDao
) : IBoostRepository {

    private val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    private val workManager = WorkManager.getInstance(context)

    override fun getRunningApps(): Flow<List<RunningApp>> = flow {
        val runningProcesses = activityManager.runningAppProcesses ?: emptyList()
        val whitelist = getWhitelistSync()
        val runningApps = runningProcesses.mapNotNull { process ->
            val packageName = process.pkgList?.firstOrNull() ?: return@mapNotNull null
            val appName = getAppName(packageName)
            val memoryInfo = android.os.Debug.MemoryInfo()
            android.os.Debug.getMemoryInfo(memoryInfo)
            val memoryUsage = memoryInfo.totalPss.toLong()
            RunningApp(
                packageName = packageName,
                processName = process.processName,
                memoryUsage = memoryUsage,
                appName = appName,
                isWhitelisted = whitelist.contains(packageName)
            )
        }
        emit(runningApps)
    }

    private suspend fun getWhitelistSync(): Set<String> {
        return whitelistedAppDao.getWhitelistedApps().first().map { it.packageName }.toSet()
    }

    override suspend fun boostMemory(whitelistedPackages: Set<String>): Long {
        val runningProcesses = activityManager.runningAppProcesses ?: emptyList()
        var totalFreedMemory = 0L
        runningProcesses.forEach { process ->
            val packageName = process.pkgList?.firstOrNull() ?: return@forEach
            if (!whitelistedPackages.contains(packageName) && !isSystemApp(packageName)) {
                try {
                    activityManager.killBackgroundProcesses(packageName)
                    // Estimate freed memory (simplified)
                    totalFreedMemory += process.importance // rough estimate
                } catch (e: Exception) {
                    // Handle permission or other errors
                }
            }
        }
        return totalFreedMemory
    }

    override suspend fun addToWhitelist(packageName: String) {
        val appName = getAppName(packageName)
        val whitelistedApp = WhitelistedApp(
            packageName = packageName,
            appName = appName,
            isWhitelisted = true
        )
        whitelistedAppDao.insert(whitelistedApp)
    }

    override suspend fun removeFromWhitelist(packageName: String) {
        whitelistedAppDao.deleteByPackageName(packageName)
    }

    override fun getWhitelist(): Flow<Set<String>> = whitelistedAppDao.getWhitelistedApps()
        .map { apps -> apps.map { it.packageName }.toSet() }

    override suspend fun scheduleAutoBoost(intervalHours: Int) {
        val workRequest = PeriodicWorkRequestBuilder<MemoryBoostWorker>(intervalHours.toLong(), TimeUnit.HOURS)
            .build()
        workManager.enqueueUniquePeriodicWork(
            "auto_boost",
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequest
        )
    }

    override suspend fun cancelAutoBoost() {
        workManager.cancelUniqueWork("auto_boost")
    }

    private fun getAppName(packageName: String): String {
        return try {
            val pm = context.packageManager
            val appInfo = pm.getApplicationInfo(packageName, 0)
            pm.getApplicationLabel(appInfo).toString()
        } catch (e: Exception) {
            packageName
        }
    }

    private fun isSystemApp(packageName: String): Boolean {
        return try {
            val pm = context.packageManager
            val appInfo = pm.getApplicationInfo(packageName, 0)
            (appInfo.flags and android.content.pm.ApplicationInfo.FLAG_SYSTEM) != 0
        } catch (e: Exception) {
            false
        }
    }
}