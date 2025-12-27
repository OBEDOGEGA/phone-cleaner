package com.smartcleaner.pro.presentation.ui.tools;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/tools/DuplicateFileAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/smartcleaner/pro/domain/model/DuplicateFile;", "Lcom/smartcleaner/pro/presentation/ui/tools/DuplicateFileAdapter$DuplicateFileViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DuplicateFileViewHolder", "app_debug"})
public final class DuplicateFileAdapter extends androidx.recyclerview.widget.ListAdapter<com.smartcleaner.pro.domain.model.DuplicateFile, com.smartcleaner.pro.presentation.ui.tools.DuplicateFileAdapter.DuplicateFileViewHolder> {
    
    public DuplicateFileAdapter() {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.smartcleaner.pro.presentation.ui.tools.DuplicateFileAdapter.DuplicateFileViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.smartcleaner.pro.presentation.ui.tools.DuplicateFileAdapter.DuplicateFileViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/smartcleaner/pro/presentation/ui/tools/DuplicateFileAdapter$DuplicateFileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/smartcleaner/pro/databinding/ItemDuplicateFileBinding;", "(Lcom/smartcleaner/pro/databinding/ItemDuplicateFileBinding;)V", "bind", "", "duplicateFile", "Lcom/smartcleaner/pro/domain/model/DuplicateFile;", "formatFileSize", "", "size", "", "app_debug"})
    public static final class DuplicateFileViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.smartcleaner.pro.databinding.ItemDuplicateFileBinding binding = null;
        
        public DuplicateFileViewHolder(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.databinding.ItemDuplicateFileBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.smartcleaner.pro.domain.model.DuplicateFile duplicateFile) {
        }
        
        private final java.lang.String formatFileSize(long size) {
            return null;
        }
    }
}