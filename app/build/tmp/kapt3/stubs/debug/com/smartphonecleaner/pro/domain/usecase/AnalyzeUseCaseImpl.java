package com.smartphonecleaner.pro.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/smartphonecleaner/pro/domain/usecase/AnalyzeUseCaseImpl;", "Lcom/smartphonecleaner/pro/domain/usecase/IAnalyzeUseCase;", "analyzeRepository", "Lcom/smartphonecleaner/pro/domain/repository/IAnalyzeRepository;", "(Lcom/smartphonecleaner/pro/domain/repository/IAnalyzeRepository;)V", "findDuplicateFiles", "", "Lcom/smartphonecleaner/pro/domain/model/DuplicateFile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLargeFiles", "Lcom/smartphonecleaner/pro/domain/model/LargeFile;", "minSizeBytes", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppDetails", "Lcom/smartphonecleaner/pro/domain/model/AppInfo;", "packageName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInstalledApps", "Lkotlinx/coroutines/flow/Flow;", "isSdCardAvailable", "", "moveAppToSdCard", "uninstallApp", "app_debug"})
public final class AnalyzeUseCaseImpl implements com.smartphonecleaner.pro.domain.usecase.IAnalyzeUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.smartphonecleaner.pro.domain.repository.IAnalyzeRepository analyzeRepository = null;
    
    @javax.inject.Inject()
    public AnalyzeUseCaseImpl(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.domain.repository.IAnalyzeRepository analyzeRepository) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.smartphonecleaner.pro.domain.model.AppInfo>> getInstalledApps() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAppDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.smartphonecleaner.pro.domain.model.AppInfo> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object uninstallApp(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object moveAppToSdCard(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object isSdCardAvailable(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object findDuplicateFiles(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.smartphonecleaner.pro.domain.model.DuplicateFile>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object findLargeFiles(long minSizeBytes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.smartphonecleaner.pro.domain.model.LargeFile>> $completion) {
        return null;
    }
}