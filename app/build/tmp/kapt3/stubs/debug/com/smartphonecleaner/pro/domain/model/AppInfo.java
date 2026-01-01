package com.smartphonecleaner.pro.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001B\u00af\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u00a2\u0006\u0002\u0010\u001aJ\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u00c6\u0003J\t\u00102\u001a\u00020\u0007H\u00c6\u0003J\t\u00103\u001a\u00020\u0007H\u00c6\u0003J\t\u00104\u001a\u00020\u0007H\u00c6\u0003J\t\u00105\u001a\u00020\u0007H\u00c6\u0003J\t\u00106\u001a\u00020\u0016H\u00c6\u0003J\t\u00107\u001a\u00020\u0016H\u00c6\u0003J\t\u00108\u001a\u00020\fH\u00c6\u0003J\t\u00109\u001a\u00020\fH\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0007H\u00c6\u0003J\t\u0010=\u001a\u00020\u0007H\u00c6\u0003J\t\u0010>\u001a\u00020\u0007H\u00c6\u0003J\t\u0010?\u001a\u00020\u0007H\u00c6\u0003J\t\u0010@\u001a\u00020\fH\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u00c5\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\fH\u00c6\u0001J\u0013\u0010C\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010E\u001a\u00020\u0016H\u00d6\u0001J\t\u0010F\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0018\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010$R\u0011\u0010\u0019\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010$R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010$R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\'R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001e\u00a8\u0006G"}, d2 = {"Lcom/smartphonecleaner/pro/domain/model/AppInfo;", "", "packageName", "", "appName", "versionName", "versionCode", "", "size", "lastUpdateTime", "firstInstallTime", "isSystemApp", "", "icon", "Landroid/graphics/drawable/Drawable;", "permissions", "", "storageUsed", "cacheSize", "dataSize", "apkSize", "targetSdkVersion", "", "minSdkVersion", "isEnabled", "isRunning", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJZLandroid/graphics/drawable/Drawable;Ljava/util/List;JJJJIIZZ)V", "getApkSize", "()J", "getAppName", "()Ljava/lang/String;", "getCacheSize", "getDataSize", "getFirstInstallTime", "getIcon", "()Landroid/graphics/drawable/Drawable;", "()Z", "getLastUpdateTime", "getMinSdkVersion", "()I", "getPackageName", "getPermissions", "()Ljava/util/List;", "getSize", "getStorageUsed", "getTargetSdkVersion", "getVersionCode", "getVersionName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class AppInfo {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String packageName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String appName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String versionName = null;
    private final long versionCode = 0L;
    private final long size = 0L;
    private final long lastUpdateTime = 0L;
    private final long firstInstallTime = 0L;
    private final boolean isSystemApp = false;
    @org.jetbrains.annotations.Nullable()
    private final android.graphics.drawable.Drawable icon = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> permissions = null;
    private final long storageUsed = 0L;
    private final long cacheSize = 0L;
    private final long dataSize = 0L;
    private final long apkSize = 0L;
    private final int targetSdkVersion = 0;
    private final int minSdkVersion = 0;
    private final boolean isEnabled = false;
    private final boolean isRunning = false;
    
    public AppInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    java.lang.String appName, @org.jetbrains.annotations.NotNull()
    java.lang.String versionName, long versionCode, long size, long lastUpdateTime, long firstInstallTime, boolean isSystemApp, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable icon, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> permissions, long storageUsed, long cacheSize, long dataSize, long apkSize, int targetSdkVersion, int minSdkVersion, boolean isEnabled, boolean isRunning) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPackageName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAppName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVersionName() {
        return null;
    }
    
    public final long getVersionCode() {
        return 0L;
    }
    
    public final long getSize() {
        return 0L;
    }
    
    public final long getLastUpdateTime() {
        return 0L;
    }
    
    public final long getFirstInstallTime() {
        return 0L;
    }
    
    public final boolean isSystemApp() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.drawable.Drawable getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPermissions() {
        return null;
    }
    
    public final long getStorageUsed() {
        return 0L;
    }
    
    public final long getCacheSize() {
        return 0L;
    }
    
    public final long getDataSize() {
        return 0L;
    }
    
    public final long getApkSize() {
        return 0L;
    }
    
    public final int getTargetSdkVersion() {
        return 0;
    }
    
    public final int getMinSdkVersion() {
        return 0;
    }
    
    public final boolean isEnabled() {
        return false;
    }
    
    public final boolean isRunning() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    public final long component11() {
        return 0L;
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final long component14() {
        return 0L;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final boolean component17() {
        return false;
    }
    
    public final boolean component18() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.drawable.Drawable component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smartphonecleaner.pro.domain.model.AppInfo copy(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    java.lang.String appName, @org.jetbrains.annotations.NotNull()
    java.lang.String versionName, long versionCode, long size, long lastUpdateTime, long firstInstallTime, boolean isSystemApp, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable icon, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> permissions, long storageUsed, long cacheSize, long dataSize, long apkSize, int targetSdkVersion, int minSdkVersion, boolean isEnabled, boolean isRunning) {
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