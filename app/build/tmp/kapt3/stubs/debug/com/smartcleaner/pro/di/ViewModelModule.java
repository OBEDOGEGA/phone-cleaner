package com.smartcleaner.pro.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/smartcleaner/pro/di/ViewModelModule;", "", "()V", "bindAnalyzeUseCase", "Lcom/smartcleaner/pro/domain/usecase/IAnalyzeUseCase;", "useCase", "Lcom/smartcleaner/pro/domain/usecase/AnalyzeUseCaseImpl;", "bindBoostUseCase", "Lcom/smartcleaner/pro/domain/usecase/IBoostUseCase;", "Lcom/smartcleaner/pro/domain/usecase/BoostUseCaseImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ViewModelComponent.class})
public abstract class ViewModelModule {
    
    public ViewModelModule() {
        super();
    }
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartcleaner.pro.domain.usecase.IAnalyzeUseCase bindAnalyzeUseCase(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.domain.usecase.AnalyzeUseCaseImpl useCase);
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract com.smartcleaner.pro.domain.usecase.IBoostUseCase bindBoostUseCase(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.domain.usecase.BoostUseCaseImpl useCase);
}