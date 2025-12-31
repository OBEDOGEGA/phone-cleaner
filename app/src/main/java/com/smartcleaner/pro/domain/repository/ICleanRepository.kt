package com.smartcleaner.pro.domain.repository

import com.smartcleaner.pro.domain.model.JunkItem
import kotlinx.coroutines.flow.Flow

interface ICleanRepository {
    fun scanForJunk(): Flow<List<JunkItem>>
    suspend fun cleanJunk(items: List<JunkItem>): Long
    suspend fun getTotalJunkSize(): Long
    suspend fun scheduleAutoClean(intervalHours: Int)
    suspend fun cancelAutoClean()
}