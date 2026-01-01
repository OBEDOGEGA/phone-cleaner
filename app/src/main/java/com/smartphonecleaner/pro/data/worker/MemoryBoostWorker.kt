package com.smartphonecleaner.pro.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.smartphonecleaner.pro.domain.repository.IBoostRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first

@HiltWorker
class MemoryBoostWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val boostRepository: IBoostRepository
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            val whitelist = boostRepository.getWhitelist().first()
            boostRepository.boostMemory(whitelist)
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}