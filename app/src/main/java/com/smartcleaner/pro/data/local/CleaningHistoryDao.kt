package com.smartcleaner.pro.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CleaningHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cleaningHistory: CleaningHistory)

    @Query("SELECT * FROM cleaning_history ORDER BY timestamp DESC")
    fun getAll(): Flow<List<CleaningHistory>>

    @Query("SELECT * FROM cleaning_history WHERE id = :id")
    suspend fun getById(id: Long): CleaningHistory?

    @Query("DELETE FROM cleaning_history WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM cleaning_history")
    suspend fun deleteAll()
}