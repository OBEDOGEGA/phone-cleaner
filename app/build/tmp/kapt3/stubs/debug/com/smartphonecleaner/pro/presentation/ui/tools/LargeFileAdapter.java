package com.smartphonecleaner.pro.presentation.ui.tools;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/tools/LargeFileAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/smartphonecleaner/pro/domain/model/LargeFile;", "Lcom/smartphonecleaner/pro/presentation/ui/tools/LargeFileAdapter$LargeFileViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "LargeFileViewHolder", "app_debug"})
public final class LargeFileAdapter extends androidx.recyclerview.widget.ListAdapter<com.smartphonecleaner.pro.domain.model.LargeFile, com.smartphonecleaner.pro.presentation.ui.tools.LargeFileAdapter.LargeFileViewHolder> {
    
    public LargeFileAdapter() {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.smartphonecleaner.pro.presentation.ui.tools.LargeFileAdapter.LargeFileViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.smartphonecleaner.pro.presentation.ui.tools.LargeFileAdapter.LargeFileViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/tools/LargeFileAdapter$LargeFileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smartphonecleaner/pro/databinding/ItemLargeFileBinding;", "(Lcom/smartphonecleaner/pro/databinding/ItemLargeFileBinding;)V", "bind", "", "largeFile", "Lcom/smartphonecleaner/pro/domain/model/LargeFile;", "formatDate", "", "timestamp", "", "formatFileSize", "size", "app_debug"})
    public static final class LargeFileViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smartphonecleaner.pro.databinding.ItemLargeFileBinding binding = null;
        
        public LargeFileViewHolder(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.databinding.ItemLargeFileBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.domain.model.LargeFile largeFile) {
        }
        
        private final java.lang.String formatFileSize(long size) {
            return null;
        }
        
        private final java.lang.String formatDate(long timestamp) {
            return null;
        }
    }
}