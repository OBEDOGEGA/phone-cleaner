package com.smartphonecleaner.pro.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u001fH\u0016J\u000e\u0010 \u001a\u00020!H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010#\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/smartphonecleaner/pro/data/repository/AnalyzeRepositoryImpl;", "Lcom/smartphonecleaner/pro/domain/repository/IAnalyzeRepository;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "packageManager", "Landroid/content/pm/PackageManager;", "calculateMD5", "", "file", "Ljava/io/File;", "createAppInfo", "Lcom/smartphonecleaner/pro/domain/model/AppInfo;", "packageInfo", "Landroid/content/pm/PackageInfo;", "findDuplicateFiles", "", "Lcom/smartphonecleaner/pro/domain/model/DuplicateFile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLargeFiles", "Lcom/smartphonecleaner/pro/domain/model/LargeFile;", "minSizeBytes", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppDetails", "packageName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppSize", "getFileExtension", "fileName", "getInstalledApps", "Lkotlinx/coroutines/flow/Flow;", "isSdCardAvailable", "", "moveAppToSdCard", "uninstallApp", "app_debug"})
public final class AnalyzeRepositoryImpl implements com.smartphonecleaner.pro.domain.repository.IAnalyzeRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.pm.PackageManager packageManager = null;
    
    @javax.inject.Inject()
    public AnalyzeRepositoryImpl(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
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
    
    private final com.smartphonecleaner.pro.domain.model.AppInfo createAppInfo(android.content.pm.PackageInfo packageInfo) {
        return null;
    }
    
    private final long getAppSize(android.content.pm.PackageInfo packageInfo) {
        return 0L;
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
    
    private final java.lang.String calculateMD5(java.io.File file) {
        return null;
    }
    
    private final java.lang.String getFileExtension(java.lang.String fileName) {
        return null;
    }
}