package com.smartcleaner.pro.presentation.ui.cleaner;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\u001a\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u00a8\u00060"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/cleaner/SummaryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/smartcleaner/pro/databinding/FragmentSummaryBinding;", "adManager", "Lcom/smartcleaner/pro/data/remote/AdManager;", "getAdManager", "()Lcom/smartcleaner/pro/data/remote/AdManager;", "setAdManager", "(Lcom/smartcleaner/pro/data/remote/AdManager;)V", "binding", "getBinding", "()Lcom/smartcleaner/pro/databinding/FragmentSummaryBinding;", "featureUnlockHelper", "Lcom/smartcleaner/pro/utils/FeatureUnlockHelper;", "getFeatureUnlockHelper", "()Lcom/smartcleaner/pro/utils/FeatureUnlockHelper;", "setFeatureUnlockHelper", "(Lcom/smartcleaner/pro/utils/FeatureUnlockHelper;)V", "viewModel", "Lcom/smartcleaner/pro/presentation/viewmodel/CleanerViewModel;", "getViewModel", "()Lcom/smartcleaner/pro/presentation/viewmodel/CleanerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "displayResults", "", "formatFileSize", "", "size", "", "navigateToDashboard", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "playConfettiAnimation", "setupClickListeners", "setupObservers", "showRewardedAdForDeepClean", "app_debug"})
public final class SummaryFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.smartcleaner.pro.databinding.FragmentSummaryBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject()
    public com.smartcleaner.pro.data.remote.AdManager adManager;
    @javax.inject.Inject()
    public com.smartcleaner.pro.utils.FeatureUnlockHelper featureUnlockHelper;
    
    public SummaryFragment() {
        super();
    }
    
    private final com.smartcleaner.pro.databinding.FragmentSummaryBinding getBinding() {
        return null;
    }
    
    private final com.smartcleaner.pro.presentation.viewmodel.CleanerViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcleaner.pro.data.remote.AdManager getAdManager() {
        return null;
    }
    
    public final void setAdManager(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.data.remote.AdManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcleaner.pro.utils.FeatureUnlockHelper getFeatureUnlockHelper() {
        return null;
    }
    
    public final void setFeatureUnlockHelper(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.utils.FeatureUnlockHelper p0) {
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
    
    private final void setupObservers() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void showRewardedAdForDeepClean() {
    }
    
    private final void navigateToDashboard() {
    }
    
    private final void displayResults() {
    }
    
    private final void playConfettiAnimation() {
    }
    
    private final java.lang.String formatFileSize(long size) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}