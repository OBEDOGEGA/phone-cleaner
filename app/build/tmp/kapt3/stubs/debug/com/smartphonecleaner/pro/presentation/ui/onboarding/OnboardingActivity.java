package com.smartphonecleaner.pro.presentation.ui.onboarding;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/onboarding/OnboardingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/smartphonecleaner/pro/presentation/ui/onboarding/OnboardingAdapter;", "binding", "Lcom/smartphonecleaner/pro/databinding/ActivityOnboardingBinding;", "permissionManager", "Lcom/smartphonecleaner/pro/utils/PermissionManager;", "getPermissionManager", "()Lcom/smartphonecleaner/pro/utils/PermissionManager;", "setPermissionManager", "(Lcom/smartphonecleaner/pro/utils/PermissionManager;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "completeOnboarding", "", "isOnboardingCompleted", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupButtons", "setupViewPager", "startMainActivity", "app_debug"})
public final class OnboardingActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.smartphonecleaner.pro.databinding.ActivityOnboardingBinding binding;
    private androidx.viewpager2.widget.ViewPager2 viewPager;
    private com.smartphonecleaner.pro.presentation.ui.onboarding.OnboardingAdapter adapter;
    @javax.inject.Inject()
    public android.content.SharedPreferences sharedPreferences;
    @javax.inject.Inject()
    public com.smartphonecleaner.pro.utils.PermissionManager permissionManager;
    
    public OnboardingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final void setSharedPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartphonecleaner.pro.utils.PermissionManager getPermissionManager() {
        return null;
    }
    
    public final void setPermissionManager(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.utils.PermissionManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewPager() {
    }
    
    private final void setupButtons() {
    }
    
    private final void completeOnboarding() {
    }
    
    private final void startMainActivity() {
    }
    
    private final boolean isOnboardingCompleted() {
        return false;
    }
}