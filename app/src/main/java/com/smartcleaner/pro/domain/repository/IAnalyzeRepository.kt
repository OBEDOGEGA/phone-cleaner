package com.smartcleaner.pro.domain.repository

import com.smartcleaner.pro.domain.model.AppInfo
import com.smartcleaner.pro.domain.model.DuplicateFile
import com.smartcleaner.pro.domain.model.LargeFile
import kotlinx.coroutines.flow.Flow

interface IAnalyzeRepository {
    // Interface for analyze-related data operations

    // App management methods
    fun getInstalledApps(): Flow<List<AppInfo>>
    suspend fun getAppDetails(packageName: String): AppInfo?
    suspend fun uninstallApp(packageName: String): Boolean
    suspend fun moveAppToSdCard(packageName: String): Boolean
    suspend fun isSdCardAvailable(): Boolean

    // Tools methods
    suspend fun findDuplicateFiles(): List<DuplicateFile>
    suspend fun findLargeFiles(minSizeBytes: Long = 100 * 1024 * 1024): List<LargeFile> // Default 100MB
}