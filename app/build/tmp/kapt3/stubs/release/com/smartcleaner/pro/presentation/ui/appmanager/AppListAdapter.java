package com.smartcleaner.pro.presentation.ui.appmanager;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0007\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004 !\"#B=\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0014\u0010\u001b\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001dJ\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adManager", "Lcom/smartcleaner/pro/data/remote/AdManager;", "onAppClick", "Lkotlin/Function1;", "Lcom/smartcleaner/pro/domain/model/AppInfo;", "", "onAppSelectionChanged", "Lkotlin/Function2;", "", "", "(Lcom/smartcleaner/pro/data/remote/AdManager;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "selectedApps", "", "selectionMode", "getItemViewType", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedApps", "selected", "", "setSelectionMode", "enabled", "AdViewHolder", "AppListItemDiffCallback", "AppViewHolder", "Companion", "app_release"})
public final class AppListAdapter extends androidx.recyclerview.widget.ListAdapter<com.smartcleaner.pro.presentation.ui.appmanager.AppListItem, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.smartcleaner.pro.data.remote.AdManager adManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.smartcleaner.pro.domain.model.AppInfo, kotlin.Unit> onAppClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Boolean, kotlin.Unit> onAppSelectionChanged = null;
    private static final int VIEW_TYPE_APP_ITEM = 0;
    private static final int VIEW_TYPE_AD = 1;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> selectedApps = null;
    private boolean selectionMode = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.smartcleaner.pro.presentation.ui.appmanager.AppListAdapter.Companion Companion = null;
    
    @javax.inject.Inject()
    public AppListAdapter(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.data.remote.AdManager adManager, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.smartcleaner.pro.domain.model.AppInfo, kotlin.Unit> onAppClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onAppSelectionChanged) {
        super(null);
    }
    
    public final void setSelectionMode(boolean enabled) {
    }
    
    public final void setSelectedApps(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> selected) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListAdapter$AdViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smartcleaner/pro/databinding/NativeAdLayoutBinding;", "(Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListAdapter;Lcom/smartcleaner/pro/databinding/NativeAdLayoutBinding;)V", "bind", "", "nativeAd", "Lcom/google/android/gms/ads/nativead/NativeAd;", "app_release"})
    public final class AdViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smartcleaner.pro.databinding.NativeAdLayoutBinding binding = null;
        
        public AdViewHolder(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.databinding.NativeAdLayoutBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.Nullable()
        com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListAdapter$AppListItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    public static final class AppListItemDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.smartcleaner.pro.presentation.ui.appmanager.AppListItem> {
        
        public AppListItemDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.presentation.ui.appmanager.AppListItem oldItem, @org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.presentation.ui.appmanager.AppListItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.presentation.ui.appmanager.AppListItem oldItem, @org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.presentation.ui.appmanager.AppListItem newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListAdapter$AppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smartcleaner/pro/databinding/ItemAppBinding;", "(Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListAdapter;Lcom/smartcleaner/pro/databinding/ItemAppBinding;)V", "bind", "", "appInfo", "Lcom/smartcleaner/pro/domain/model/AppInfo;", "formatSize", "", "bytes", "", "app_release"})
    public final class AppViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smartcleaner.pro.databinding.ItemAppBinding binding = null;
        
        public AppViewHolder(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.databinding.ItemAppBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.domain.model.AppInfo appInfo) {
        }
        
        private final java.lang.String formatSize(long bytes) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/appmanager/AppListAdapter$Companion;", "", "()V", "VIEW_TYPE_AD", "", "VIEW_TYPE_APP_ITEM", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}