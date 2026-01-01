package com.smartphonecleaner.pro.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "whitelisted_apps")
data class WhitelistedApp(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val packageName: String,
    val appName: String,
    val isWhitelisted: Boolean = true
)