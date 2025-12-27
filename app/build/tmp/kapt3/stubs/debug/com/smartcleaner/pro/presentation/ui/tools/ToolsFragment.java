package com.smartcleaner.pro.presentation.ui.tools;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\u001a\u0010\'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006*"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/tools/ToolsFragment;", "Lcom/smartcleaner/pro/presentation/common/BaseFragment;", "()V", "_binding", "Lcom/smartcleaner/pro/databinding/FragmentToolsBinding;", "adManager", "Lcom/smartcleaner/pro/data/remote/AdManager;", "getAdManager", "()Lcom/smartcleaner/pro/data/remote/AdManager;", "setAdManager", "(Lcom/smartcleaner/pro/data/remote/AdManager;)V", "binding", "getBinding", "()Lcom/smartcleaner/pro/databinding/FragmentToolsBinding;", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "toolsAdapter", "Lcom/smartcleaner/pro/presentation/ui/tools/ToolsAdapter;", "viewModel", "Lcom/smartcleaner/pro/presentation/viewmodel/ToolsViewModel;", "getViewModel", "()Lcom/smartcleaner/pro/presentation/viewmodel/ToolsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkPermissions", "", "navigateToDuplicateFinder", "navigateToLargeFiles", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupRecyclerView", "app_debug"})
public final class ToolsFragment extends com.smartcleaner.pro.presentation.common.BaseFragment {
    @javax.inject.Inject()
    public com.smartcleaner.pro.data.remote.AdManager adManager;
    @org.jetbrains.annotations.Nullable()
    private com.smartcleaner.pro.databinding.FragmentToolsBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.smartcleaner.pro.presentation.ui.tools.ToolsAdapter toolsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestPermissionLauncher = null;
    
    public ToolsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcleaner.pro.data.remote.AdManager getAdManager() {
        return null;
    }
    
    public final void setAdManager(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.data.remote.AdManager p0) {
    }
    
    private final com.smartcleaner.pro.databinding.FragmentToolsBinding getBinding() {
        return null;
    }
    
    private final com.smartcleaner.pro.presentation.viewmodel.ToolsViewModel getViewModel() {
        return null;
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
    
    private final void checkPermissions() {
    }
    
    private final void navigateToDuplicateFinder() {
    }
    
    private final void navigateToLargeFiles() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}