package com.smartcleaner.pro.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.smartcleaner.pro.data.local.AdImpressionDao
import com.smartcleaner.pro.data.local.CleaningHistoryDao
import com.smartcleaner.pro.data.local.PhoneCleanerDatabase
import com.smartcleaner.pro.data.local.UserPreferenceDao
import com.smartcleaner.pro.data.local.WhitelistedAppDao
import com.smartcleaner.pro.data.repository.AnalyzeRepositoryImpl
import com.smartcleaner.pro.data.repository.BoostRepositoryImpl
import com.smartcleaner.pro.data.repository.CleanRepositoryImpl
import com.smartcleaner.pro.domain.repository.IAnalyzeRepository
import com.smartcleaner.pro.domain.repository.IBoostRepository
import com.smartcleaner.pro.domain.repository.ICleanRepository
import com.smartcleaner.pro.utils.PermissionManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCleanRepository(repository: CleanRepositoryImpl): ICleanRepository

    @Binds
    abstract fun bindBoostRepository(repository: BoostRepositoryImpl): IBoostRepository

    @Binds
    abstract fun bindAnalyzeRepository(repository: AnalyzeRepositoryImpl): IAnalyzeRepository

    companion object {
        @Provides
        @Singleton
        fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
            return context.getSharedPreferences("boost_prefs", Context.MODE_PRIVATE)
        }

        @Provides
        @Singleton
        fun providePermissionManager(@ApplicationContext context: Context): PermissionManager {
            return PermissionManager(context)
        }

        @Provides
        @Singleton
        fun providePhoneCleanerDatabase(@ApplicationContext context: Context): PhoneCleanerDatabase {
            return Room.databaseBuilder(
                context,
                PhoneCleanerDatabase::class.java,
                "phone_cleaner_db"
            ).build()
        }

        @Provides
        @Singleton
        fun provideCleaningHistoryDao(database: PhoneCleanerDatabase): CleaningHistoryDao {
            return database.cleaningHistoryDao()
        }

        @Provides
        @Singleton
        fun provideWhitelistedAppDao(database: PhoneCleanerDatabase): WhitelistedAppDao {
            return database.whitelistedAppDao()
        }

        @Provides
        @Singleton
        fun provideUserPreferenceDao(database: PhoneCleanerDatabase): UserPreferenceDao {
            return database.userPreferenceDao()
        }

        @Provides
        @Singleton
        fun provideAdImpressionDao(database: PhoneCleanerDatabase): AdImpressionDao {
            return database.adImpressionDao()
        }
    }
}