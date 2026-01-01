package com.smartphonecleaner.pro.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/viewmodel/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "cleanUseCase", "Lcom/smartphonecleaner/pro/domain/usecase/ICleanUseCase;", "(Lcom/smartphonecleaner/pro/domain/usecase/ICleanUseCase;)V", "cancelAutoClean", "", "scheduleAutoClean", "intervalHours", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.smartphonecleaner.pro.domain.usecase.ICleanUseCase cleanUseCase = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.domain.usecase.ICleanUseCase cleanUseCase) {
        super();
    }
    
    public final void scheduleAutoClean(int intervalHours) {
    }
    
    public final void cancelAutoClean() {
    }
}