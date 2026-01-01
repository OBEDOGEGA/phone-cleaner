package com.smartphonecleaner.pro.domain.model

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
    val storageUsed: Long = 0L, // additional storage info if available
    val cacheSize: Long = 0L, // cache size in bytes
    val dataSize: Long = 0L, // data size in bytes
    val apkSize: Long = 0L, // APK size in bytes
    val targetSdkVersion: Int = 0,
    val minSdkVersion: Int = 0,
    val isEnabled: Boolean = true,
    val isRunning: Boolean = false
)