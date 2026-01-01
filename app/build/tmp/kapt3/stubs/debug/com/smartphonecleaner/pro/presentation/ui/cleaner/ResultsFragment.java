package com.smartphonecleaner.pro.presentation.ui.cleaner;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020 H\u0016J\u001a\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0002J\u0016\u00100\u001a\u00020 2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00061"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/smartphonecleaner/pro/databinding/FragmentResultsBinding;", "adManager", "Lcom/smartphonecleaner/pro/data/remote/AdManager;", "getAdManager", "()Lcom/smartphonecleaner/pro/data/remote/AdManager;", "setAdManager", "(Lcom/smartphonecleaner/pro/data/remote/AdManager;)V", "adapter", "Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsAdapter;", "binding", "getBinding", "()Lcom/smartphonecleaner/pro/databinding/FragmentResultsBinding;", "viewModel", "Lcom/smartphonecleaner/pro/presentation/viewmodel/CleanerViewModel;", "getViewModel", "()Lcom/smartphonecleaner/pro/presentation/viewmodel/CleanerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createListWithAds", "", "Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem;", "items", "Lcom/smartphonecleaner/pro/domain/model/JunkItem;", "formatFileSize", "", "size", "", "navigateToClean", "", "selectedItems", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupClickListeners", "setupObservers", "setupRecyclerView", "updateTotalSize", "app_debug"})
public final class ResultsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.smartphonecleaner.pro.databinding.FragmentResultsBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsAdapter adapter;
    @javax.inject.Inject()
    public com.smartphonecleaner.pro.data.remote.AdManager adManager;
    
    public ResultsFragment() {
        super();
    }
    
    private final com.smartphonecleaner.pro.databinding.FragmentResultsBinding getBinding() {
        return null;
    }
    
    private final com.smartphonecleaner.pro.presentation.viewmodel.CleanerViewModel getViewModel() {
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
    
    private final void setupRecyclerView() {
    }
    
    private final void setupObservers() {
    }
    
    private final java.util.List<com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem> createListWithAds(java.util.List<com.smartphonecleaner.pro.domain.model.JunkItem> items) {
        return null;
    }
    
    private final void setupClickListeners() {
    }
    
    private final void updateTotalSize(java.util.List<com.smartphonecleaner.pro.domain.model.JunkItem> items) {
    }
    
    private final void navigateToClean(java.util.List<com.smartphonecleaner.pro.domain.model.JunkItem> selectedItems) {
    }
    
    private final java.lang.String formatFileSize(long size) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}