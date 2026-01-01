package com.smartphonecleaner.pro.domain.usecase

import com.smartphonecleaner.pro.domain.model.RunningApp
import kotlinx.coroutines.flow.Flow

interface IBoostUseCase {
    fun getRunningApps(): Flow<List<RunningApp>>
    suspend fun boostMemory(): Long
    suspend fun toggleWhitelist(packageName: String)
    fun getWhitelist(): Flow<Set<String>>
    suspend fun scheduleAutoBoost(intervalHours: Int)
    suspend fun cancelAutoBoost()
}