package com.smartcleaner.pro.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010*\u001a\u00020\tJ\b\u0010+\u001a\u00020,H\u0014J\u0014\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010/\u001a\u00020,J\u0006\u00100\u001a\u00020,J\u0006\u00101\u001a\u00020,J\u0016\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\t0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019\u00a8\u00065"}, d2 = {"Lcom/smartcleaner/pro/presentation/viewmodel/CleanerViewModel;", "Landroidx/lifecycle/ViewModel;", "cleanUseCase", "Lcom/smartcleaner/pro/domain/usecase/ICleanUseCase;", "(Lcom/smartcleaner/pro/domain/usecase/ICleanUseCase;)V", "_cleanProgress", "Landroidx/lifecycle/MutableLiveData;", "", "_cleanTime", "", "_isCleaning", "", "_isScanning", "_junkItems", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/smartcleaner/pro/domain/model/JunkItem;", "_scanProgress", "_spaceSaved", "_totalJunkSize", "cleanJob", "Lkotlinx/coroutines/Job;", "cleanProgress", "Landroidx/lifecycle/LiveData;", "getCleanProgress", "()Landroidx/lifecycle/LiveData;", "cleanTime", "getCleanTime", "isCleaning", "isScanning", "junkItems", "Lkotlinx/coroutines/flow/StateFlow;", "getJunkItems", "()Lkotlinx/coroutines/flow/StateFlow;", "scanJob", "scanProgress", "getScanProgress", "spaceSaved", "getSpaceSaved", "totalJunkSize", "getTotalJunkSize", "getSelectedItems", "getTotalSelectedSize", "onCleared", "", "startCleaning", "selectedItems", "startScanning", "stopCleaning", "stopScanning", "updateJunkItemSelection", "item", "isSelected", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CleanerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.smartcleaner.pro.domain.usecase.ICleanUseCase cleanUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _scanProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> scanProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isScanning = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isScanning = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> _junkItems = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> junkItems = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _totalJunkSize = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> totalJunkSize = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isCleaning = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isCleaning = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _cleanProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> cleanProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _spaceSaved = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> spaceSaved = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _cleanTime = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> cleanTime = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job scanJob;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job cleanJob;
    
    @javax.inject.Inject()
    public CleanerViewModel(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.domain.usecase.ICleanUseCase cleanUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getScanProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isScanning() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> getJunkItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getTotalJunkSize() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isCleaning() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getCleanProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getSpaceSaved() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getCleanTime() {
        return null;
    }
    
    public final void startScanning() {
    }
    
    public final void stopScanning() {
    }
    
    public final void startCleaning(@org.jetbrains.annotations.NotNull()
    java.util.List<com.smartcleaner.pro.domain.model.JunkItem> selectedItems) {
    }
    
    public final void stopCleaning() {
    }
    
    public final void updateJunkItemSelection(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.domain.model.JunkItem item, boolean isSelected) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.smartcleaner.pro.domain.model.JunkItem> getSelectedItems() {
        return null;
    }
    
    public final long getTotalSelectedSize() {
        return 0L;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}