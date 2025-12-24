package com.smartcleaner.pro.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WhitelistedAppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(whitelistedApp: WhitelistedApp)

    @Update
    suspend fun update(whitelistedApp: WhitelistedApp)

    @Query("SELECT * FROM whitelisted_apps WHERE isWhitelisted = 1")
    fun getWhitelistedApps(): Flow<List<WhitelistedApp>>

    @Query("SELECT * FROM whitelisted_apps WHERE packageName = :packageName")
    suspend fun getByPackageName(packageName: String): WhitelistedApp?

    @Query("DELETE FROM whitelisted_apps WHERE packageName = :packageName")
    suspend fun deleteByPackageName(packageName: String)

    @Query("DELETE FROM whitelisted_apps")
    suspend fun deleteAll()
}