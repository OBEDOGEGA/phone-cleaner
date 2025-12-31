package com.smartcleaner.pro.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/smartcleaner/pro/domain/repository/ICleanRepository;", "", "cleanJunk", "", "items", "", "Lcom/smartcleaner/pro/domain/model/JunkItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalJunkSize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanForJunk", "Lkotlinx/coroutines/flow/Flow;", "app_release"})
public abstract interface ICleanRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.smartcleaner.pro.domain.model.JunkItem>> scanForJunk();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object cleanJunk(@org.jetbrains.annotations.NotNull()
    java.util.List<com.smartcleaner.pro.domain.model.JunkItem> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalJunkSize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
}