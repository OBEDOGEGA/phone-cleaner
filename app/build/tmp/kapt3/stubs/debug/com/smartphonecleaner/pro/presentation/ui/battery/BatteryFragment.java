package com.smartphonecleaner.pro.presentation.ui.battery;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016J\u001a\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010\'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006+"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/battery/BatteryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/smartphonecleaner/pro/databinding/FragmentBatteryBinding;", "adManager", "Lcom/smartphonecleaner/pro/data/remote/AdManager;", "getAdManager", "()Lcom/smartphonecleaner/pro/data/remote/AdManager;", "setAdManager", "(Lcom/smartphonecleaner/pro/data/remote/AdManager;)V", "binding", "getBinding", "()Lcom/smartphonecleaner/pro/databinding/FragmentBatteryBinding;", "viewModel", "Lcom/smartphonecleaner/pro/presentation/viewmodel/BatteryViewModel;", "getViewModel", "()Lcom/smartphonecleaner/pro/presentation/viewmodel/BatteryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "formatTimeout", "", "timeout", "", "loadBannerAd", "", "loadBatteryInfo", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "openBackgroundAppsSettings", "openScreenTimeoutSettings", "performBatteryOptimization", "setupClickListeners", "setupObservers", "app_debug"})
public final class BatteryFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.smartphonecleaner.pro.databinding.FragmentBatteryBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject()
    public com.smartphonecleaner.pro.data.remote.AdManager adManager;
    
    public BatteryFragment() {
        super();
    }
    
    private final com.smartphonecleaner.pro.databinding.FragmentBatteryBinding getBinding() {
        return null;
    }
    
    private final com.smartphonecleaner.pro.presentation.viewmodel.BatteryViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartphonecleaner.pro.data.remote.AdManager getAdManager() {
        return null;
    }
    
    public final void setAdManager(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.data.remote.AdManager p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadBannerAd() {
    }
    
    private final void setupObservers() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void loadBatteryInfo() {
    }
    
    private final void performBatteryOptimization() {
    }
    
    private final void openScreenTimeoutSettings() {
    }
    
    private final void openBackgroundAppsSettings() {
    }
    
    private final java.lang.String formatTimeout(int timeout) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}