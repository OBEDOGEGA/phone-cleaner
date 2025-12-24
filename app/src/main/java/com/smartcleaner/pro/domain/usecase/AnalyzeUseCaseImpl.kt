package com.smartcleaner.pro.domain.usecase

import com.smartcleaner.pro.domain.model.AppInfo
import com.smartcleaner.pro.domain.model.DuplicateFile
import com.smartcleaner.pro.domain.model.LargeFile
import com.smartcleaner.pro.domain.repository.IAnalyzeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnalyzeUseCaseImpl @Inject constructor(
    private val analyzeRepository: IAnalyzeRepository
) : IAnalyzeUseCase {

    override fun getInstalledApps(): Flow<List<AppInfo>> {
        return analyzeRepository.getInstalledApps()
    }

    override suspend fun getAppDetails(packageName: String): AppInfo? {
        return analyzeRepository.getAppDetails(packageName)
    }

    override suspend fun uninstallApp(packageName: String): Boolean {
        return analyzeRepository.uninstallApp(packageName)
    }

    override suspend fun moveAppToSdCard(packageName: String): Boolean {
        return analyzeRepository.moveAppToSdCard(packageName)
    }

    override suspend fun isSdCardAvailable(): Boolean {
        return analyzeRepository.isSdCardAvailable()
    }

    override suspend fun findDuplicateFiles(): List<DuplicateFile> {
        return analyzeRepository.findDuplicateFiles()
    }

    override suspend fun findLargeFiles(minSizeBytes: Long): List<LargeFile> {
        return analyzeRepository.findLargeFiles(minSizeBytes)
    }
}