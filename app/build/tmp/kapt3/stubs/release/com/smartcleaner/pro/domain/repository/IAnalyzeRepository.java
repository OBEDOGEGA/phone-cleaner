package com.smartcleaner.pro.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u0011H&J\u000e\u0010\u0012\u001a\u00020\u0013H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/smartcleaner/pro/domain/repository/IAnalyzeRepository;", "", "findDuplicateFiles", "", "Lcom/smartcleaner/pro/domain/model/DuplicateFile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLargeFiles", "Lcom/smartcleaner/pro/domain/model/LargeFile;", "minSizeBytes", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppDetails", "Lcom/smartcleaner/pro/domain/model/AppInfo;", "packageName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInstalledApps", "Lkotlinx/coroutines/flow/Flow;", "isSdCardAvailable", "", "moveAppToSdCard", "uninstallApp", "app_release"})
public abstract interface IAnalyzeRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.smartcleaner.pro.domain.model.AppInfo>> getInstalledApps();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAppDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.smartcleaner.pro.domain.model.AppInfo> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uninstallApp(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object moveAppToSdCard(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object isSdCardAvailable(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findDuplicateFiles(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.DuplicateFile>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findLargeFiles(long minSizeBytes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.LargeFile>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}