package com.smartphonecleaner.pro.presentation.ui.cleaner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0015\u0016\u0017\u0018B)\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adManager", "Lcom/smartphonecleaner/pro/data/remote/AdManager;", "onItemChecked", "Lkotlin/Function2;", "Lcom/smartphonecleaner/pro/domain/model/JunkItem;", "", "", "(Lcom/smartphonecleaner/pro/data/remote/AdManager;Lkotlin/jvm/functions/Function2;)V", "getItemViewType", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AdViewHolder", "Companion", "JunkItemViewHolder", "ResultsListItemDiffCallback", "app_debug"})
public final class ResultsAdapter extends androidx.recyclerview.widget.ListAdapter<com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.smartphonecleaner.pro.data.remote.AdManager adManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<com.smartphonecleaner.pro.domain.model.JunkItem, java.lang.Boolean, kotlin.Unit> onItemChecked = null;
    private static final int VIEW_TYPE_JUNK_ITEM = 0;
    private static final int VIEW_TYPE_AD = 1;
    @org.jetbrains.annotations.NotNull()
    public static final com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsAdapter.Companion Companion = null;
    
    @javax.inject.Inject()
    public ResultsAdapter(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.data.remote.AdManager adManager, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.smartphonecleaner.pro.domain.model.JunkItem, ? super java.lang.Boolean, kotlin.Unit> onItemChecked) {
        super(null);
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsAdapter$AdViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smartphonecleaner/pro/databinding/NativeAdLayoutBinding;", "(Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsAdapter;Lcom/smartphonecleaner/pro/databinding/NativeAdLayoutBinding;)V", "bind", "", "nativeAd", "Lcom/google/android/gms/ads/nativead/NativeAd;", "app_debug"})
    public final class AdViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smartphonecleaner.pro.databinding.NativeAdLayoutBinding binding = null;
        
        public AdViewHolder(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.databinding.NativeAdLayoutBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.Nullable()
        com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsAdapter$Companion;", "", "()V", "VIEW_TYPE_AD", "", "VIEW_TYPE_JUNK_ITEM", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsAdapter$JunkItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smartphonecleaner/pro/databinding/ItemJunkFileBinding;", "(Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsAdapter;Lcom/smartphonecleaner/pro/databinding/ItemJunkFileBinding;)V", "bind", "", "item", "Lcom/smartphonecleaner/pro/domain/model/JunkItem;", "formatFileSize", "", "size", "", "app_debug"})
    public final class JunkItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smartphonecleaner.pro.databinding.ItemJunkFileBinding binding = null;
        
        public JunkItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.databinding.ItemJunkFileBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.domain.model.JunkItem item) {
        }
        
        private final java.lang.String formatFileSize(long size) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsAdapter$ResultsListItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class ResultsListItemDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem> {
        
        public ResultsListItemDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem oldItem, @org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem oldItem, @org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem newItem) {
            return false;
        }
    }
}