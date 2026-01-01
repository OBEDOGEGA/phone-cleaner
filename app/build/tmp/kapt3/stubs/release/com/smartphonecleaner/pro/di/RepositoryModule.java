package com.smartphonecleaner.pro.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/smartphonecleaner/pro/di/RepositoryModule;", "", "()V", "bindAnalyzeRepository", "Lcom/smartphonecleaner/pro/domain/repository/IAnalyzeRepository;", "repository", "Lcom/smartphonecleaner/pro/data/repository/AnalyzeRepositoryImpl;", "bindBoostRepository", "Lcom/smartphonecleaner/pro/domain/repository/IBoostRepository;", "Lcom/smartphonecleaner/pro/data/repository/BoostRepositoryImpl;", "bindCleanRepository", "Lcom/smartphonecleaner/pro/domain/repository/ICleanRepository;", "Lcom/smartphonecleaner/pro/data/repository/CleanRepositoryImpl;", "Companion", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.smartphonecleaner.pro.di.RepositoryModule.Companion Companion = null;
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartphonecleaner.pro.domain.repository.ICleanRepository bindCleanRepository(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.data.repository.CleanRepositoryImpl repository);
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartphonecleaner.pro.domain.repository.IBoostRepository bindBoostRepository(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.data.repository.BoostRepositoryImpl repository);
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartphonecleaner.pro.domain.repository.IAnalyzeRepository bindAnalyzeRepository(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.data.repository.AnalyzeRepositoryImpl repository);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/smartphonecleaner/pro/di/RepositoryModule$Companion;", "", "()V", "provideAdImpressionDao", "Lcom/smartphonecleaner/pro/data/local/AdImpressionDao;", "database", "Lcom/smartphonecleaner/pro/data/local/PhoneCleanerDatabase;", "provideCleaningHistoryDao", "Lcom/smartphonecleaner/pro/data/local/CleaningHistoryDao;", "providePermissionManager", "Lcom/smartphonecleaner/pro/utils/PermissionManager;", "context", "Landroid/content/Context;", "providePhoneCleanerDatabase", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "provideUserPreferenceDao", "Lcom/smartphonecleaner/pro/data/local/UserPreferenceDao;", "provideWhitelistedAppDao", "Lcom/smartphonecleaner/pro/data/local/WhitelistedAppDao;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final android.content.SharedPreferences provideSharedPreferences(@dagger.hilt.android.qualifiers.ApplicationContext()
        @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.utils.PermissionManager providePermissionManager(@dagger.hilt.android.qualifiers.ApplicationContext()
        @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.data.local.PhoneCleanerDatabase providePhoneCleanerDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
        @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.data.local.CleaningHistoryDao provideCleaningHistoryDao(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.data.local.PhoneCleanerDatabase database) {
            return null;
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.data.local.WhitelistedAppDao provideWhitelistedAppDao(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.data.local.PhoneCleanerDatabase database) {
            return null;
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.data.local.UserPreferenceDao provideUserPreferenceDao(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.data.local.PhoneCleanerDatabase database) {
            return null;
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.data.local.AdImpressionDao provideAdImpressionDao(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.data.local.PhoneCleanerDatabase database) {
            return null;
        }
    }
}