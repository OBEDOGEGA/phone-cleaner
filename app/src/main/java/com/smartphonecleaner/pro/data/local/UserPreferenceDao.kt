package com.smartphonecleaner.pro.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserPreferenceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userPreference: UserPreference)

    @Update
    suspend fun update(userPreference: UserPreference)

    @Query("SELECT * FROM user_preferences")
    fun getAll(): Flow<List<UserPreference>>

    @Query("SELECT value FROM user_preferences WHERE `key` = :key")
    suspend fun getValueByKey(key: String): String?

    @Query("DELETE FROM user_preferences WHERE `key` = :key")
    suspend fun deleteByKey(key: String)

    @Query("DELETE FROM user_preferences")
    suspend fun deleteAll()
}