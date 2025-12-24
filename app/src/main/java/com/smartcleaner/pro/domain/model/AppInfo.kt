package com.smartcleaner.pro.domain.model

import android.graphics.drawable.Drawable

data class AppInfo(
    val packageName: String,
    val appName: String,
    val versionName: String,
    val versionCode: Long,
    val size: Long, // in bytes
    val lastUpdateTime: Long,
    val firstInstallTime: Long,
    val isSystemApp: Boolean,
    val icon: Drawable?,
    val permissions: List<String> = emptyList(),
    val storageUsed: Long = 0L // additional storage info if available
)