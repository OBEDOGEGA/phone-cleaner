package com.smartcleaner.pro.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.smartcleaner.pro.domain.repository.ICleanRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class ScheduledCleaningWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val cleanRepository: ICleanRepository
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            // Scan for junk files
            val junkItems = cleanRepository.scanForJunk()

            // Collect all items (since this is automated, clean all found items)
            val allItems = junkItems.firstOrNull() ?: emptyList()

            if (allItems.isNotEmpty()) {
                // Clean all junk items
                val cleanedSize = cleanRepository.cleanJunk(allItems)

                // Log the cleaning result (you could send a notification here)
                android.util.Log.d("ScheduledCleaningWorker", "Cleaned ${allItems.size} files, freed ${cleanedSize} bytes")
            }

            Result.success()
        } catch (e: Exception) {
            android.util.Log.e("ScheduledCleaningWorker", "Cleaning failed", e)
            Result.failure()
        }
    }
}