package com.smartcleaner.pro.domain.repository

import com.smartcleaner.pro.domain.model.RunningApp
import kotlinx.coroutines.flow.Flow

interface IBoostRepository {
    fun getRunningApps(): Flow<List<RunningApp>>
    suspend fun boostMemory(whitelistedPackages: Set<String>): Long // returns freed memory in KB
    suspend fun addToWhitelist(packageName: String)
    suspend fun removeFromWhitelist(packageName: String)
    fun getWhitelist(): Flow<Set<String>>
    suspend fun scheduleAutoBoost(intervalHours: Int)
    suspend fun cancelAutoBoost()
}