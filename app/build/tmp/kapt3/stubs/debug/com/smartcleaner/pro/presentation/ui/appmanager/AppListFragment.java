package com.smartcleaner.pro.presentation.ui.appmanager;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\u001a\u0010&\u001a\u00020\u001c2\u0006\u0010\'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006,"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListFragment;", "Lcom/smartcleaner/pro/presentation/common/BaseFragment;", "()V", "_binding", "Lcom/smartcleaner/pro/databinding/FragmentAppListBinding;", "adManager", "Lcom/smartcleaner/pro/data/remote/AdManager;", "getAdManager", "()Lcom/smartcleaner/pro/data/remote/AdManager;", "setAdManager", "(Lcom/smartcleaner/pro/data/remote/AdManager;)V", "adapter", "Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListAdapter;", "binding", "getBinding", "()Lcom/smartcleaner/pro/databinding/FragmentAppListBinding;", "viewModel", "Lcom/smartcleaner/pro/presentation/viewmodel/AppManagerViewModel;", "getViewModel", "()Lcom/smartcleaner/pro/presentation/viewmodel/AppManagerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createListWithAds", "", "Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListItem;", "apps", "Lcom/smartcleaner/pro/domain/model/AppInfo;", "observeViewModel", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupBatchOperations", "setupRecyclerView", "setupSpinners", "showNativeAdInEmptyState", "app_debug"})
public final class AppListFragment extends com.smartcleaner.pro.presentation.common.BaseFragment {
    @org.jetbrains.annotations.Nullable()
    private com.smartcleaner.pro.databinding.FragmentAppListBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.smartcleaner.pro.presentation.ui.appmanager.AppListAdapter adapter;
    @javax.inject.Inject()
    public com.smartcleaner.pro.data.remote.AdManager adManager;
    
    public AppListFragment() {
        super();
    }
    
    private final com.smartcleaner.pro.databinding.FragmentAppListBinding getBinding() {
        return null;
    }
    
    private final com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel getViewModel() {
        return null;
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
    
    private final void setupSpinners() {
    }
    
    private final void setupBatchOperations() {
    }
    
    private final void observeViewModel() {
    }
    
    private final java.util.List<com.smartcleaner.pro.presentation.ui.appmanager.AppListItem> createListWithAds(java.util.List<com.smartcleaner.pro.domain.model.AppInfo> apps) {
        return null;
    }
    
    private final void showNativeAdInEmptyState() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}