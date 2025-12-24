package com.smartcleaner.pro.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        CleaningHistory::class,
        WhitelistedApp::class,
        UserPreference::class,
        AdImpression::class
    ],
    version = 1,
    exportSchema = true
)
abstract class PhoneCleanerDatabase : RoomDatabase() {

    abstract fun cleaningHistoryDao(): CleaningHistoryDao
    abstract fun whitelistedAppDao(): WhitelistedAppDao
    abstract fun userPreferenceDao(): UserPreferenceDao
    abstract fun adImpressionDao(): AdImpressionDao
}