package com.smartcleaner.pro.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ad_impressions")
data class AdImpression(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val adId: String,
    val timestamp: Long,
    val impressionType: String // e.g., "shown", "clicked"
)