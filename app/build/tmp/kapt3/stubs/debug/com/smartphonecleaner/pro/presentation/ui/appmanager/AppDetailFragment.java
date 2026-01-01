package com.smartphonecleaner.pro.presentation.ui.appmanager;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\u001a\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010\'\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006)"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/appmanager/AppDetailFragment;", "Lcom/smartphonecleaner/pro/presentation/common/BaseFragment;", "()V", "_binding", "Lcom/smartphonecleaner/pro/databinding/FragmentAppDetailBinding;", "binding", "getBinding", "()Lcom/smartphonecleaner/pro/databinding/FragmentAppDetailBinding;", "permissionsAdapter", "Lcom/smartphonecleaner/pro/presentation/ui/appmanager/PermissionsAdapter;", "viewModel", "Lcom/smartphonecleaner/pro/presentation/viewmodel/AppManagerViewModel;", "getViewModel", "()Lcom/smartphonecleaner/pro/presentation/viewmodel/AppManagerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "displayAppDetails", "", "appInfo", "Lcom/smartphonecleaner/pro/domain/model/AppInfo;", "formatDate", "", "timestamp", "", "formatSize", "bytes", "loadAppDetails", "packageName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupActionButtons", "setupPermissionsRecyclerView", "app_debug"})
public final class AppDetailFragment extends com.smartphonecleaner.pro.presentation.common.BaseFragment {
    @org.jetbrains.annotations.Nullable()
    private com.smartphonecleaner.pro.databinding.FragmentAppDetailBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.smartphonecleaner.pro.presentation.ui.appmanager.PermissionsAdapter permissionsAdapter;
    
    public AppDetailFragment() {
        super();
    }
    
    private final com.smartphonecleaner.pro.databinding.FragmentAppDetailBinding getBinding() {
        return null;
    }
    
    private final com.smartphonecleaner.pro.presentation.viewmodel.AppManagerViewModel getViewModel() {
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
    
    private final void setupPermissionsRecyclerView() {
    }
    
    private final void setupActionButtons(java.lang.String packageName) {
    }
    
    private final void loadAppDetails(java.lang.String packageName) {
    }
    
    private final void displayAppDetails(com.smartphonecleaner.pro.domain.model.AppInfo appInfo) {
    }
    
    private final java.lang.String formatSize(long bytes) {
        return null;
    }
    
    private final java.lang.String formatDate(long timestamp) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}