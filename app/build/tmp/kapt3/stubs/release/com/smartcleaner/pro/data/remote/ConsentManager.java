package com.smartcleaner.pro.data.remote;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u0010H\u0082@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\bH\u0082@\u00a2\u0006\u0002\u0010\u0012J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0010J\"\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019H\u0002J\u0006\u0010\u001c\u001a\u00020\u0015J\"\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/smartcleaner/pro/data/remote/ConsentManager;", "", "context", "Landroid/content/Context;", "userPreferenceDao", "Lcom/smartcleaner/pro/data/local/UserPreferenceDao;", "(Landroid/content/Context;Lcom/smartcleaner/pro/data/local/UserPreferenceDao;)V", "CONSENT_GIVEN_KEY", "", "CONSENT_STATUS_KEY", "TAG", "consentForm", "Lcom/google/android/ump/ConsentForm;", "consentInformation", "Lcom/google/android/ump/ConsentInformation;", "canRequestAds", "", "getStoredConsentGiven", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStoredConsentStatus", "initializeConsent", "", "activity", "Landroid/app/Activity;", "onConsentComplete", "Lkotlin/Function0;", "isPersonalizedAdsAllowed", "loadAndShowConsentForm", "resetConsent", "showConsentForm", "storeConsentGiven", "given", "storeConsentStatus", "status", "app_release"})
public final class ConsentManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartcleaner.pro.data.local.UserPreferenceDao userPreferenceDao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "ConsentManager";
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.ump.ConsentInformation consentInformation = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.ump.ConsentForm consentForm;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String CONSENT_STATUS_KEY = "consent_status";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String CONSENT_GIVEN_KEY = "consent_given";
    
    @javax.inject.Inject()
    public ConsentManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.data.local.UserPreferenceDao userPreferenceDao) {
        super();
    }
    
    /**
     * Initialize consent and show form if needed
     */
    public final void initializeConsent(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onConsentComplete) {
    }
    
    private final void loadAndShowConsentForm(android.app.Activity activity, kotlin.jvm.functions.Function0<kotlin.Unit> onConsentComplete) {
    }
    
    private final void showConsentForm(android.app.Activity activity, kotlin.jvm.functions.Function0<kotlin.Unit> onConsentComplete) {
    }
    
    /**
     * Check if ads can be requested
     */
    public final boolean canRequestAds() {
        return false;
    }
    
    /**
     * Check if personalized ads are allowed
     */
    public final boolean isPersonalizedAdsAllowed() {
        return false;
    }
    
    /**
     * Reset consent (for testing or user request)
     */
    public final void resetConsent() {
    }
    
    private final void storeConsentStatus(java.lang.String status) {
    }
    
    private final java.lang.Object getStoredConsentStatus(kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final void storeConsentGiven(boolean given) {
    }
    
    private final java.lang.Object getStoredConsentGiven(kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}