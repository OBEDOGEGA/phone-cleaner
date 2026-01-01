package com.smartphonecleaner.pro.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/smartphonecleaner/pro/data/local/PhoneCleanerDatabase;", "Landroidx/room/RoomDatabase;", "()V", "adImpressionDao", "Lcom/smartphonecleaner/pro/data/local/AdImpressionDao;", "cleaningHistoryDao", "Lcom/smartphonecleaner/pro/data/local/CleaningHistoryDao;", "userPreferenceDao", "Lcom/smartphonecleaner/pro/data/local/UserPreferenceDao;", "whitelistedAppDao", "Lcom/smartphonecleaner/pro/data/local/WhitelistedAppDao;", "app_release"})
@androidx.room.Database(entities = {com.smartphonecleaner.pro.data.local.CleaningHistory.class, com.smartphonecleaner.pro.data.local.WhitelistedApp.class, com.smartphonecleaner.pro.data.local.UserPreference.class, com.smartphonecleaner.pro.data.local.AdImpression.class}, version = 1, exportSchema = true)
public abstract class PhoneCleanerDatabase extends androidx.room.RoomDatabase {
    
    public PhoneCleanerDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartphonecleaner.pro.data.local.CleaningHistoryDao cleaningHistoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartphonecleaner.pro.data.local.WhitelistedAppDao whitelistedAppDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartphonecleaner.pro.data.local.UserPreferenceDao userPreferenceDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartphonecleaner.pro.data.local.AdImpressionDao adImpressionDao();
}