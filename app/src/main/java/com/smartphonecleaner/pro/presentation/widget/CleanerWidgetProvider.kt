package com.smartphonecleaner.pro.presentation.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.StatFs
import android.widget.RemoteViews
import com.smartphonecleaner.pro.MainActivity
import com.smartphonecleaner.pro.R

class CleanerWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val views = RemoteViews(context.packageName, R.layout.widget_cleaner)

        // Get storage information
        val storageInfo = getStorageInfo()
        views.setTextViewText(R.id.widget_storage_used, storageInfo.first)
        views.setTextViewText(R.id.widget_storage_free, storageInfo.second)

        // Set up click intent to open main activity
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent, PendingIntent.FLAG_IMMUTABLE
        )
        views.setOnClickPendingIntent(R.id.widget_container, pendingIntent)

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    private fun getStorageInfo(): Pair<String, String> {
        return try {
            val stat = StatFs("/data")
            val blockSize = stat.blockSizeLong
            val totalBlocks = stat.blockCountLong
            val availableBlocks = stat.availableBlocksLong

            val totalStorage = totalBlocks * blockSize
            val usedStorage = (totalBlocks - availableBlocks) * blockSize

            val usedText = formatSize(usedStorage) + " used"
            val freeText = formatSize(totalStorage - usedStorage) + " free"

            Pair(usedText, freeText)
        } catch (e: Exception) {
            Pair("N/A", "N/A")
        }
    }

    private fun formatSize(bytes: Long): String {
        val units = arrayOf("B", "KB", "MB", "GB")
        var size = bytes.toDouble()
        var unitIndex = 0

        while (size >= 1024 && unitIndex < units.size - 1) {
            size /= 1024
            unitIndex++
        }

        return "%.1f%s".format(size, units[unitIndex])
    }
}