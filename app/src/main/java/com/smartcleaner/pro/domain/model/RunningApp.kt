package com.smartcleaner.pro.domain.model

data class RunningApp(
    val packageName: String,
    val processName: String,
    val memoryUsage: Long, // in KB
    val appName: String,
    val isWhitelisted: Boolean = false
)