package com.smartcleaner.pro.utils;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cJ\u0006\u0010\u001d\u001a\u00020\u0011J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0006\u0010\u001f\u001a\u00020\u0011J \u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010$J(\u0010%\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010$J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010\'\u001a\u00020\u0016J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0002J\u0006\u0010*\u001a\u00020\u0011J\u0006\u0010+\u001a\u00020\u0011J\u0006\u0010,\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020\u0011J\u000e\u0010.\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010/\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u00061"}, d2 = {"Lcom/smartcleaner/pro/utils/FeatureUnlockHelper;", "", "context", "Landroid/content/Context;", "adManager", "Lcom/smartcleaner/pro/data/remote/AdManager;", "(Landroid/content/Context;Lcom/smartcleaner/pro/data/remote/AdManager;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "cleanup", "", "clearAllUnlockedFeatures", "cloudBackupUnlocked", "", "customThemesUnlocked", "deepCleanUnlocked", "duplicatePhotoFinderUnlocked", "formatRemainingTime", "", "remainingMs", "", "getRemainingTime", "feature", "getUnlockedFeatures", "", "hasAnyFeatureUnlocked", "isFeatureUnlocked", "privacyEraserProUnlocked", "requestDeepCleanUnlock", "activity", "Landroid/app/Activity;", "onAdClosed", "Lkotlin/Function0;", "requestFeatureUnlockViaRewardedAd", "setupRewardedAdCallback", "featureToUnlock", "trackFeatureUsage", "action", "unlockCloudBackup", "unlockCustomThemes", "unlockDeepClean", "unlockDuplicatePhotoFinder", "unlockFeature", "unlockPrivacyEraserPro", "Companion", "app_debug"})
public final class FeatureUnlockHelper {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartcleaner.pro.data.remote.AdManager adManager = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "FeatureUnlockHelper";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "FeatureUnlockPrefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FEATURE_DEEP_CLEAN = "deep_clean";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FEATURE_DUPLICATE_PHOTO_FINDER = "duplicate_photo_finder";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FEATURE_PRIVACY_ERASER_PRO = "privacy_eraser_pro";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FEATURE_CUSTOM_THEMES = "custom_themes";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FEATURE_CLOUD_BACKUP = "cloud_backup";
    private static final long UNLOCK_DURATION_MS = 86400000L;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy sharedPreferences$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.smartcleaner.pro.utils.FeatureUnlockHelper.Companion Companion = null;
    
    @javax.inject.Inject()
    public FeatureUnlockHelper(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.data.remote.AdManager adManager) {
        super();
    }
    
    private final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final boolean deepCleanUnlocked() {
        return false;
    }
    
    public final boolean duplicatePhotoFinderUnlocked() {
        return false;
    }
    
    public final boolean privacyEraserProUnlocked() {
        return false;
    }
    
    public final boolean customThemesUnlocked() {
        return false;
    }
    
    public final boolean cloudBackupUnlocked() {
        return false;
    }
    
    public final boolean unlockFeature(@org.jetbrains.annotations.NotNull()
    java.lang.String feature) {
        return false;
    }
    
    private final boolean isFeatureUnlocked(java.lang.String feature) {
        return false;
    }
    
    public final long getRemainingTime(@org.jetbrains.annotations.NotNull()
    java.lang.String feature) {
        return 0L;
    }
    
    public final void clearAllUnlockedFeatures() {
    }
    
    private final void trackFeatureUsage(java.lang.String feature, java.lang.String action) {
    }
    
    public final boolean unlockDeepClean() {
        return false;
    }
    
    public final boolean unlockDuplicatePhotoFinder() {
        return false;
    }
    
    public final boolean unlockPrivacyEraserPro() {
        return false;
    }
    
    public final boolean unlockCustomThemes() {
        return false;
    }
    
    public final boolean unlockCloudBackup() {
        return false;
    }
    
    public final boolean hasAnyFeatureUnlocked() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getUnlockedFeatures() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatRemainingTime(long remainingMs) {
        return null;
    }
    
    public final void setupRewardedAdCallback(@org.jetbrains.annotations.NotNull()
    java.lang.String featureToUnlock) {
    }
    
    public final void requestFeatureUnlockViaRewardedAd(@org.jetbrains.annotations.NotNull()
    java.lang.String feature, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAdClosed) {
    }
    
    public final void requestDeepCleanUnlock(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAdClosed) {
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/smartcleaner/pro/utils/FeatureUnlockHelper$Companion;", "", "()V", "FEATURE_CLOUD_BACKUP", "", "FEATURE_CUSTOM_THEMES", "FEATURE_DEEP_CLEAN", "FEATURE_DUPLICATE_PHOTO_FINDER", "FEATURE_PRIVACY_ERASER_PRO", "PREFS_NAME", "TAG", "UNLOCK_DURATION_MS", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}