package com.smartphonecleaner.pro.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.smartphonecleaner.pro.domain.repository.ICleanRepository
import com.smartphonecleaner.pro.utils.NotificationManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first

@HiltWorker
class ScheduledCleaningWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val cleanRepository: ICleanRepository,
    private val notificationManager: NotificationManager
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            // Show notification that cleaning has started
            notificationManager.showScheduledCleaningNotification()

            // Scan for junk files
            val junkItems = cleanRepository.scanForJunk()

            // Collect all items (since this is automated, clean all found items)
            val allItems = junkItems.first()

            if (allItems.isNotEmpty()) {
                // Clean all junk items
                val cleanedSize = cleanRepository.cleanJunk(allItems)

                // Show completion notification
                notificationManager.showCleaningCompleteNotification(cleanedSize, allItems.size)

                android.util.Log.d("ScheduledCleaningWorker", "Cleaned ${allItems.size} files, freed ${cleanedSize} bytes")
            } else {
                // Show completion notification even if no files were found
                notificationManager.showCleaningCompleteNotification(0L, 0)
            }

            Result.success()
        } catch (e: Exception) {
            android.util.Log.e("ScheduledCleaningWorker", "Cleaning failed", e)
            Result.failure()
        }
    }
}