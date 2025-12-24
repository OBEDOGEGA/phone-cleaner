package com.smartcleaner.pro.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AdImpressionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(adImpression: AdImpression)

    @Query("SELECT * FROM ad_impressions ORDER BY timestamp DESC")
    fun getAll(): Flow<List<AdImpression>>

    @Query("SELECT COUNT(*) FROM ad_impressions WHERE adId = :adId AND impressionType = :type")
    suspend fun getCountByAdIdAndType(adId: String, type: String): Int

    @Query("DELETE FROM ad_impressions WHERE timestamp < :beforeTimestamp")
    suspend fun deleteOlderThan(beforeTimestamp: Long)

    @Query("DELETE FROM ad_impressions")
    suspend fun deleteAll()
}