package com.smartphonecleaner.pro.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cleaning_history")
data class CleaningHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val timestamp: Long,
    val cleanedSize: Long,
    val cleanedItems: Int,
    val duration: Long // in milliseconds
)