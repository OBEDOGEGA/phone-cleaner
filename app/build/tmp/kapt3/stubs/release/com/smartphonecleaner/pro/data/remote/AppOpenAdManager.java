package com.smartphonecleaner.pro.data.remote;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0007J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/smartphonecleaner/pro/data/remote/AppOpenAdManager;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "adImpressionDao", "Lcom/smartphonecleaner/pro/data/local/AdImpressionDao;", "consentManager", "Lcom/smartphonecleaner/pro/data/remote/ConsentManager;", "(Landroid/content/Context;Lcom/smartphonecleaner/pro/data/local/AdImpressionDao;Lcom/smartphonecleaner/pro/data/remote/ConsentManager;)V", "TAG", "", "appOpenAd", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "appOpenAdUnitId", "appOpenCooldownMs", "", "isLoadingAd", "", "isShowingAd", "lastAppOpenTime", "isAdAvailable", "loadAd", "", "onStart", "showAdIfAvailable", "trackAdImpression", "adId", "type", "app_release"})
public final class AppOpenAdManager implements androidx.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartphonecleaner.pro.data.local.AdImpressionDao adImpressionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartphonecleaner.pro.data.remote.ConsentManager consentManager = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "AppOpenAdManager";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String appOpenAdUnitId = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.ads.appopen.AppOpenAd appOpenAd;
    private boolean isLoadingAd = false;
    private boolean isShowingAd = false;
    private long lastAppOpenTime = 0L;
    private final long appOpenCooldownMs = 1800000L;
    
    @javax.inject.Inject()
    public AppOpenAdManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.data.local.AdImpressionDao adImpressionDao, @org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.data.remote.ConsentManager consentManager) {
        super();
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_START)
    public final void onStart() {
    }
    
    private final void loadAd() {
    }
    
    private final void showAdIfAvailable() {
    }
    
    private final boolean isAdAvailable() {
        return false;
    }
    
    private final void trackAdImpression(java.lang.String adId, java.lang.String type) {
    }
}