package com.smartcleaner.pro.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/smartcleaner/pro/domain/usecase/CleanUseCaseImpl;", "Lcom/smartcleaner/pro/domain/usecase/ICleanUseCase;", "cleanRepository", "Lcom/smartcleaner/pro/domain/repository/ICleanRepository;", "(Lcom/smartcleaner/pro/domain/repository/ICleanRepository;)V", "cleanJunk", "", "items", "", "Lcom/smartcleaner/pro/domain/model/JunkItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalJunkSize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanForJunk", "Lkotlinx/coroutines/flow/Flow;", "app_release"})
public final class CleanUseCaseImpl implements com.smartcleaner.pro.domain.usecase.ICleanUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.smartcleaner.pro.domain.repository.ICleanRepository cleanRepository = null;
    
    @javax.inject.Inject()
    public CleanUseCaseImpl(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.domain.repository.ICleanRepository cleanRepository) {
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
}