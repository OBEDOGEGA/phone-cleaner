package com.smartphonecleaner.pro.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013\u00a8\u0006#"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/viewmodel/MemoryBoosterViewModel;", "Landroidx/lifecycle/ViewModel;", "boostUseCase", "Lcom/smartphonecleaner/pro/domain/usecase/IBoostUseCase;", "(Lcom/smartphonecleaner/pro/domain/usecase/IBoostUseCase;)V", "_boostResult", "Landroidx/lifecycle/MutableLiveData;", "", "_isBoosting", "", "_runningApps", "", "Lcom/smartphonecleaner/pro/domain/model/RunningApp;", "_whitelist", "", "", "boostResult", "Landroidx/lifecycle/LiveData;", "getBoostResult", "()Landroidx/lifecycle/LiveData;", "isBoosting", "runningApps", "getRunningApps", "whitelist", "getWhitelist", "boostMemory", "", "cancelAutoBoost", "loadRunningApps", "loadWhitelist", "scheduleAutoBoost", "intervalHours", "", "toggleWhitelist", "packageName", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MemoryBoosterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.smartphonecleaner.pro.domain.usecase.IBoostUseCase boostUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.smartphonecleaner.pro.domain.model.RunningApp>> _runningApps = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.smartphonecleaner.pro.domain.model.RunningApp>> runningApps = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isBoosting = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isBoosting = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _boostResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> boostResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.Set<java.lang.String>> _whitelist = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.Set<java.lang.String>> whitelist = null;
    
    @javax.inject.Inject()
    public MemoryBoosterViewModel(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.domain.usecase.IBoostUseCase boostUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.smartphonecleaner.pro.domain.model.RunningApp>> getRunningApps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isBoosting() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getBoostResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Set<java.lang.String>> getWhitelist() {
        return null;
    }
    
    private final void loadRunningApps() {
    }
    
    private final void loadWhitelist() {
    }
    
    public final void boostMemory() {
    }
    
    public final void toggleWhitelist(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName) {
    }
    
    public final void scheduleAutoBoost(int intervalHours) {
    }
    
    public final void cancelAutoBoost() {
    }
}