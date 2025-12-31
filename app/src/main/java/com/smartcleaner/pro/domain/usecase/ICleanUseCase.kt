package com.smartcleaner.pro.domain.usecase

import com.smartcleaner.pro.domain.model.JunkItem
import kotlinx.coroutines.flow.Flow

interface ICleanUseCase {
    fun scanForJunk(): Flow<List<JunkItem>>
    suspend fun cleanJunk(items: List<JunkItem>): Long
    suspend fun getTotalJunkSize(): Long
    suspend fun scheduleAutoClean(intervalHours: Int)
    suspend fun cancelAutoClean()
}