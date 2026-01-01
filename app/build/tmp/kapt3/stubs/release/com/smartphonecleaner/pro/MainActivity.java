package com.smartphonecleaner.pro;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0016J\u0012\u0010&\u001a\u00020$2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020$H\u0014J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/smartphonecleaner/pro/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adManager", "Lcom/smartphonecleaner/pro/data/remote/AdManager;", "getAdManager", "()Lcom/smartphonecleaner/pro/data/remote/AdManager;", "setAdManager", "(Lcom/smartphonecleaner/pro/data/remote/AdManager;)V", "adView", "Lcom/google/android/gms/ads/AdView;", "binding", "Lcom/smartphonecleaner/pro/databinding/ActivityMainBinding;", "consentManager", "Lcom/smartphonecleaner/pro/data/remote/ConsentManager;", "getConsentManager", "()Lcom/smartphonecleaner/pro/data/remote/ConsentManager;", "setConsentManager", "(Lcom/smartphonecleaner/pro/data/remote/ConsentManager;)V", "refreshHandler", "Landroid/os/Handler;", "refreshRunnable", "Ljava/lang/Runnable;", "sessionStartTime", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "tabSwitchCount", "", "isOnboardingCompleted", "", "loadAds", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupNavigation", "startOnboardingActivity", "app_release"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.smartphonecleaner.pro.databinding.ActivityMainBinding binding;
    @javax.inject.Inject()
    public com.smartphonecleaner.pro.data.remote.AdManager adManager;
    @javax.inject.Inject()
    public com.smartphonecleaner.pro.data.remote.ConsentManager consentManager;
    @javax.inject.Inject()
    public android.content.SharedPreferences sharedPreferences;
    private com.google.android.gms.ads.AdView adView;
    private android.os.Handler refreshHandler;
    private java.lang.Runnable refreshRunnable;
    private int tabSwitchCount = 0;
    private long sessionStartTime = 0L;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartphonecleaner.pro.data.remote.AdManager getAdManager() {
        return null;
    }
    
    public final void setAdManager(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.data.remote.AdManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartphonecleaner.pro.data.remote.ConsentManager getConsentManager() {
        return null;
    }
    
    public final void setConsentManager(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.data.remote.ConsentManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final void setSharedPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadAds() {
    }
    
    private final void setupNavigation() {
    }
    
    private final boolean isOnboardingCompleted() {
        return false;
    }
    
    private final void startOnboardingActivity() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}