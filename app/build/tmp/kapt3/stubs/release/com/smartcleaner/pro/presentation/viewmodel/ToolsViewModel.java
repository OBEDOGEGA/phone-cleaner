package com.smartcleaner.pro.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/smartcleaner/pro/presentation/viewmodel/ToolsViewModel;", "Lcom/smartcleaner/pro/presentation/viewmodel/BaseViewModel;", "analyzeUseCase", "Lcom/smartcleaner/pro/domain/usecase/IAnalyzeUseCase;", "(Lcom/smartcleaner/pro/domain/usecase/IAnalyzeUseCase;)V", "_duplicateFiles", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/smartcleaner/pro/domain/model/DuplicateFile;", "_isScanningDuplicates", "", "_isScanningLargeFiles", "_largeFiles", "Lcom/smartcleaner/pro/domain/model/LargeFile;", "duplicateFiles", "Landroidx/lifecycle/LiveData;", "getDuplicateFiles", "()Landroidx/lifecycle/LiveData;", "isScanningDuplicates", "isScanningLargeFiles", "largeFiles", "getLargeFiles", "scanForDuplicateFiles", "", "scanForLargeFiles", "minSizeBytes", "", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ToolsViewModel extends com.smartcleaner.pro.presentation.viewmodel.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.smartcleaner.pro.domain.usecase.IAnalyzeUseCase analyzeUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.smartcleaner.pro.domain.model.DuplicateFile>> _duplicateFiles = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.smartcleaner.pro.domain.model.DuplicateFile>> duplicateFiles = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.smartcleaner.pro.domain.model.LargeFile>> _largeFiles = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.smartcleaner.pro.domain.model.LargeFile>> largeFiles = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isScanningDuplicates = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isScanningDuplicates = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isScanningLargeFiles = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isScanningLargeFiles = null;
    
    @javax.inject.Inject()
    public ToolsViewModel(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.domain.usecase.IAnalyzeUseCase analyzeUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.smartcleaner.pro.domain.model.DuplicateFile>> getDuplicateFiles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.smartcleaner.pro.domain.model.LargeFile>> getLargeFiles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isScanningDuplicates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isScanningLargeFiles() {
        return null;
    }
    
    public final void scanForDuplicateFiles() {
    }
    
    public final void scanForLargeFiles(long minSizeBytes) {
    }
}