package com.smartcleaner.pro.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00a2\u0006\u0002\u0010\tJ.\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@\u00a2\u0006\u0002\u0010\u001aJ<\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@\u00a2\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00a2\u0006\u0002\u0010\tJ&\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@\u00a2\u0006\u0002\u0010 J\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\"H\u0016J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\'H\u0096@\u00a2\u0006\u0002\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/smartcleaner/pro/data/repository/CleanRepositoryImpl;", "Lcom/smartcleaner/pro/domain/repository/ICleanRepository;", "context", "Landroid/content/Context;", "cleaningHistoryDao", "Lcom/smartcleaner/pro/data/local/CleaningHistoryDao;", "(Landroid/content/Context;Lcom/smartcleaner/pro/data/local/CleaningHistoryDao;)V", "cancelAutoClean", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanJunk", "", "items", "", "Lcom/smartcleaner/pro/domain/model/JunkItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalJunkSize", "scanApkFiles", "scanCacheFiles", "scanDirectory", "dir", "Ljava/io/File;", "type", "Lcom/smartcleaner/pro/domain/model/JunkType;", "category", "", "(Ljava/io/File;Lcom/smartcleaner/pro/domain/model/JunkType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanDirectoryForExtensions", "extensions", "(Ljava/io/File;Ljava/util/List;Lcom/smartcleaner/pro/domain/model/JunkType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanEmptyFolders", "scanForEmptyDirectories", "(Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanForJunk", "Lkotlinx/coroutines/flow/Flow;", "scanResidualFiles", "scanThumbnailCache", "scheduleAutoClean", "intervalHours", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CleanRepositoryImpl implements com.smartcleaner.pro.domain.repository.ICleanRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.smartcleaner.pro.data.local.CleaningHistoryDao cleaningHistoryDao = null;
    
    @javax.inject.Inject()
    public CleanRepositoryImpl(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.data.local.CleaningHistoryDao cleaningHistoryDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> scanForJunk() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object cleanJunk(@org.jetbrains.annotations.NotNull()
    java.util.List<com.smartcleaner.pro.domain.model.JunkItem> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTotalJunkSize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    private final java.lang.Object scanCacheFiles(kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> $completion) {
        return null;
    }
    
    private final java.lang.Object scanResidualFiles(kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> $completion) {
        return null;
    }
    
    private final java.lang.Object scanApkFiles(kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> $completion) {
        return null;
    }
    
    private final java.lang.Object scanEmptyFolders(kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> $completion) {
        return null;
    }
    
    private final java.lang.Object scanThumbnailCache(kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> $completion) {
        return null;
    }
    
    private final java.lang.Object scanDirectory(java.io.File dir, com.smartcleaner.pro.domain.model.JunkType type, java.lang.String category, kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> $completion) {
        return null;
    }
    
    private final java.lang.Object scanDirectoryForExtensions(java.io.File dir, java.util.List<java.lang.String> extensions, com.smartcleaner.pro.domain.model.JunkType type, java.lang.String category, kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> $completion) {
        return null;
    }
    
    private final java.lang.Object scanForEmptyDirectories(java.io.File dir, java.lang.String category, kotlin.coroutines.Continuation<? super java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object scheduleAutoClean(int intervalHours, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object cancelAutoClean(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}