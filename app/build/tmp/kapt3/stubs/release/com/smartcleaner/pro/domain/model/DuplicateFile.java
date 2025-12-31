package com.smartcleaner.pro.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u000bH\u00c6\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/smartcleaner/pro/domain/model/DuplicateFile;", "", "file", "Ljava/io/File;", "size", "", "md5Hash", "", "duplicateGroup", "", "isSelected", "", "(Ljava/io/File;JLjava/lang/String;Ljava/util/List;Z)V", "getDuplicateGroup", "()Ljava/util/List;", "getFile", "()Ljava/io/File;", "()Z", "setSelected", "(Z)V", "getMd5Hash", "()Ljava/lang/String;", "getSize", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class DuplicateFile {
    @org.jetbrains.annotations.NotNull()
    private final java.io.File file = null;
    private final long size = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String md5Hash = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.io.File> duplicateGroup = null;
    private boolean isSelected;
    
    public DuplicateFile(@org.jetbrains.annotations.NotNull()
    java.io.File file, long size, @org.jetbrains.annotations.NotNull()
    java.lang.String md5Hash, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> duplicateGroup, boolean isSelected) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getFile() {
        return null;
    }
    
    public final long getSize() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMd5Hash() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.io.File> getDuplicateGroup() {
        return null;
    }
    
    public final boolean isSelected() {
        return false;
    }
    
    public final void setSelected(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.io.File> component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartcleaner.pro.domain.model.DuplicateFile copy(@org.jetbrains.annotations.NotNull()
    java.io.File file, long size, @org.jetbrains.annotations.NotNull()
    java.lang.String md5Hash, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> duplicateGroup, boolean isSelected) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}