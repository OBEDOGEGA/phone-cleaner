package com.smartphonecleaner.pro.domain.usecase

import com.smartphonecleaner.pro.domain.model.RunningApp
import com.smartphonecleaner.pro.domain.repository.IBoostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class BoostUseCaseImpl @Inject constructor(
    private val boostRepository: IBoostRepository
) : IBoostUseCase {

    override fun getRunningApps(): Flow<List<RunningApp>> {
        return boostRepository.getRunningApps()
    }

    override suspend fun boostMemory(): Long {
        val whitelist = boostRepository.getWhitelist().first()
        return boostRepository.boostMemory(whitelist)
    }

    override suspend fun toggleWhitelist(packageName: String) {
        val currentWhitelist = boostRepository.getWhitelist().first()
        if (currentWhitelist.contains(packageName)) {
            boostRepository.removeFromWhitelist(packageName)
        } else {
            boostRepository.addToWhitelist(packageName)
        }
    }

    override fun getWhitelist(): Flow<Set<String>> {
        return boostRepository.getWhitelist()
    }

    override suspend fun scheduleAutoBoost(intervalHours: Int) {
        boostRepository.scheduleAutoBoost(intervalHours)
    }

    override suspend fun cancelAutoBoost() {
        boostRepository.cancelAutoBoost()
    }
}