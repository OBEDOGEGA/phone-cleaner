package com.smartphonecleaner.pro.presentation.ui.tools;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010\'\u001a\u00020\u001bH\u0016J\u001a\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u00a8\u00061"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/tools/LargeFilesFragment;", "Lcom/smartphonecleaner/pro/presentation/common/BaseFragment;", "()V", "_binding", "Lcom/smartphonecleaner/pro/databinding/FragmentLargeFilesBinding;", "adManager", "Lcom/smartphonecleaner/pro/data/remote/AdManager;", "getAdManager", "()Lcom/smartphonecleaner/pro/data/remote/AdManager;", "setAdManager", "(Lcom/smartphonecleaner/pro/data/remote/AdManager;)V", "binding", "getBinding", "()Lcom/smartphonecleaner/pro/databinding/FragmentLargeFilesBinding;", "largeFileAdapter", "Lcom/smartphonecleaner/pro/presentation/ui/tools/LargeFileAdapter;", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "viewModel", "Lcom/smartphonecleaner/pro/presentation/viewmodel/ToolsViewModel;", "getViewModel", "()Lcom/smartphonecleaner/pro/presentation/viewmodel/ToolsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkPermissionAndScan", "", "hasStoragePermission", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "view", "requestStoragePermission", "setupClickListeners", "setupObservers", "setupRecyclerView", "showNativeAdInEmptyState", "startScanning", "Companion", "app_release"})
public final class LargeFilesFragment extends com.smartphonecleaner.pro.presentation.common.BaseFragment {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "LargeFilesFragment";
    @org.jetbrains.annotations.Nullable()
    private com.smartphonecleaner.pro.databinding.FragmentLargeFilesBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.smartphonecleaner.pro.presentation.ui.tools.LargeFileAdapter largeFileAdapter;
    @javax.inject.Inject()
    public com.smartphonecleaner.pro.data.remote.AdManager adManager;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.smartphonecleaner.pro.presentation.ui.tools.LargeFilesFragment.Companion Companion = null;
    
    public LargeFilesFragment() {
        super();
    }
    
    private final com.smartphonecleaner.pro.databinding.FragmentLargeFilesBinding getBinding() {
        return null;
    }
    
    private final com.smartphonecleaner.pro.presentation.viewmodel.ToolsViewModel getViewModel() {
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
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void checkPermissionAndScan() {
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
    
    private final void showNativeAdInEmptyState() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/tools/LargeFilesFragment$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}