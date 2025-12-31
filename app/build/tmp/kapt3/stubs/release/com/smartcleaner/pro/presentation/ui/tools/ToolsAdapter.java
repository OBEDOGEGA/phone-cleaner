package com.smartcleaner.pro.presentation.ui.tools;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0014\u0015\u0016\u0017B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/tools/ToolsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/smartcleaner/pro/presentation/ui/tools/ToolItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adManager", "Lcom/smartcleaner/pro/data/remote/AdManager;", "onToolClick", "Lkotlin/Function1;", "Lcom/smartcleaner/pro/presentation/ui/tools/Tool;", "", "(Lcom/smartcleaner/pro/data/remote/AdManager;Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AdViewHolder", "Companion", "ToolItemDiffCallback", "ToolViewHolder", "app_release"})
public final class ToolsAdapter extends androidx.recyclerview.widget.ListAdapter<com.smartcleaner.pro.presentation.ui.tools.ToolItem, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.smartcleaner.pro.data.remote.AdManager adManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.smartcleaner.pro.presentation.ui.tools.Tool, kotlin.Unit> onToolClick = null;
    private static final int VIEW_TYPE_TOOL = 0;
    private static final int VIEW_TYPE_AD = 1;
    @org.jetbrains.annotations.NotNull()
    public static final com.smartcleaner.pro.presentation.ui.tools.ToolsAdapter.Companion Companion = null;
    
    public ToolsAdapter(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.data.remote.AdManager adManager, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.smartcleaner.pro.presentation.ui.tools.Tool, kotlin.Unit> onToolClick) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/tools/ToolsAdapter$AdViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smartcleaner/pro/databinding/NativeAdLayoutBinding;", "(Lcom/smartcleaner/pro/presentation/ui/tools/ToolsAdapter;Lcom/smartcleaner/pro/databinding/NativeAdLayoutBinding;)V", "bind", "", "app_release"})
    public final class AdViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smartcleaner.pro.databinding.NativeAdLayoutBinding binding = null;
        
        public AdViewHolder(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.databinding.NativeAdLayoutBinding binding) {
            super(null);
        }
        
        public final void bind() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/tools/ToolsAdapter$Companion;", "", "()V", "VIEW_TYPE_AD", "", "VIEW_TYPE_TOOL", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/tools/ToolsAdapter$ToolItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/smartcleaner/pro/presentation/ui/tools/ToolItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    public static final class ToolItemDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.smartcleaner.pro.presentation.ui.tools.ToolItem> {
        
        public ToolItemDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.presentation.ui.tools.ToolItem oldItem, @org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.presentation.ui.tools.ToolItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.presentation.ui.tools.ToolItem oldItem, @org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.presentation.ui.tools.ToolItem newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/tools/ToolsAdapter$ToolViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smartcleaner/pro/databinding/ItemToolBinding;", "(Lcom/smartcleaner/pro/presentation/ui/tools/ToolsAdapter;Lcom/smartcleaner/pro/databinding/ItemToolBinding;)V", "bind", "", "tool", "Lcom/smartcleaner/pro/presentation/ui/tools/Tool;", "app_release"})
    public final class ToolViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smartcleaner.pro.databinding.ItemToolBinding binding = null;
        
        public ToolViewHolder(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.databinding.ItemToolBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.presentation.ui.tools.Tool tool) {
        }
    }
}