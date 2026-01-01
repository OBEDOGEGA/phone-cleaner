package com.smartphonecleaner.pro.domain.usecase

import com.smartphonecleaner.pro.domain.model.AppInfo
import com.smartphonecleaner.pro.domain.model.DuplicateFile
import com.smartphonecleaner.pro.domain.model.LargeFile
import kotlinx.coroutines.flow.Flow

interface IAnalyzeUseCase {
    // Interface for analyze use case operations

    // App management use cases
    fun getInstalledApps(): Flow<List<AppInfo>>
    suspend fun getAppDetails(packageName: String): AppInfo?
    suspend fun uninstallApp(packageName: String): Boolean
    suspend fun moveAppToSdCard(packageName: String): Boolean
    suspend fun isSdCardAvailable(): Boolean

    // Tools use cases
    suspend fun findDuplicateFiles(): List<DuplicateFile>
    suspend fun findLargeFiles(minSizeBytes: Long = 100 * 1024 * 1024): List<LargeFile>
}