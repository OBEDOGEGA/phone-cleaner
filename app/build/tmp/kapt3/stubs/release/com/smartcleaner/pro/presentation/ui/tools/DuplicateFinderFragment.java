package com.smartcleaner.pro.presentation.ui.tools;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\u001a\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010.\u001a\u00020+H\u0002J\b\u0010/\u001a\u00020+H\u0002J\b\u00100\u001a\u00020+H\u0002J\b\u00101\u001a\u00020+H\u0002J\b\u00102\u001a\u00020+H\u0002J\b\u00103\u001a\u00020+H\u0002J\b\u00104\u001a\u00020+H\u0002J\b\u00105\u001a\u00020+H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d\u00a8\u00066"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/tools/DuplicateFinderFragment;", "Lcom/smartcleaner/pro/presentation/common/BaseFragment;", "()V", "_binding", "Lcom/smartcleaner/pro/databinding/FragmentDuplicateFinderBinding;", "adManager", "Lcom/smartcleaner/pro/data/remote/AdManager;", "getAdManager", "()Lcom/smartcleaner/pro/data/remote/AdManager;", "setAdManager", "(Lcom/smartcleaner/pro/data/remote/AdManager;)V", "binding", "getBinding", "()Lcom/smartcleaner/pro/databinding/FragmentDuplicateFinderBinding;", "duplicateAdapter", "Lcom/smartcleaner/pro/presentation/ui/tools/DuplicateFileAdapter;", "featureUnlockHelper", "Lcom/smartcleaner/pro/utils/FeatureUnlockHelper;", "getFeatureUnlockHelper", "()Lcom/smartcleaner/pro/utils/FeatureUnlockHelper;", "setFeatureUnlockHelper", "(Lcom/smartcleaner/pro/utils/FeatureUnlockHelper;)V", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "viewModel", "Lcom/smartcleaner/pro/presentation/viewmodel/ToolsViewModel;", "getViewModel", "()Lcom/smartcleaner/pro/presentation/viewmodel/ToolsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "hasStoragePermission", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "requestStoragePermission", "setupClickListeners", "setupObservers", "setupRecyclerView", "showNativeAdInEmptyState", "showPremiumMessage", "startScanning", "unlockFeature", "app_release"})
public final class DuplicateFinderFragment extends com.smartcleaner.pro.presentation.common.BaseFragment {
    @org.jetbrains.annotations.Nullable()
    private com.smartcleaner.pro.databinding.FragmentDuplicateFinderBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.smartcleaner.pro.presentation.ui.tools.DuplicateFileAdapter duplicateAdapter;
    @javax.inject.Inject()
    public com.smartcleaner.pro.utils.FeatureUnlockHelper featureUnlockHelper;
    @javax.inject.Inject()
    public com.smartcleaner.pro.data.remote.AdManager adManager;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestPermissionLauncher = null;
    
    public DuplicateFinderFragment() {
        super();
    }
    
    private final com.smartcleaner.pro.databinding.FragmentDuplicateFinderBinding getBinding() {
        return null;
    }
    
    private final com.smartcleaner.pro.presentation.viewmodel.ToolsViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcleaner.pro.utils.FeatureUnlockHelper getFeatureUnlockHelper() {
        return null;
    }
    
    public final void setFeatureUnlockHelper(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.utils.FeatureUnlockHelper p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcleaner.pro.data.remote.AdManager getAdManager() {
        return null;
    }
    
    public final void setAdManager(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.data.remote.AdManager p0) {
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
    
    private final void setupRecyclerView() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void setupObservers() {
    }
    
    private final boolean hasStoragePermission() {
        return false;
    }
    
    private final void requestStoragePermission() {
    }
    
    private final void startScanning() {
    }
    
    private final void showPremiumMessage() {
    }
    
    private final void unlockFeature() {
    }
    
    private final void showNativeAdInEmptyState() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}