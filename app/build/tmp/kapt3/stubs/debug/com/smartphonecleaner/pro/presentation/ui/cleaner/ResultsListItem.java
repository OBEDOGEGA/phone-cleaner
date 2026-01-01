package com.smartphonecleaner.pro.presentation.ui.cleaner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem;", "", "()V", "AdItem", "JunkItemWrapper", "Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem$AdItem;", "Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem$JunkItemWrapper;", "app_debug"})
public abstract class ResultsListItem {
    
    private ResultsListItem() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem$AdItem;", "Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem;", "nativeAd", "Lcom/google/android/gms/ads/nativead/NativeAd;", "(Lcom/google/android/gms/ads/nativead/NativeAd;)V", "getNativeAd", "()Lcom/google/android/gms/ads/nativead/NativeAd;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class AdItem extends com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem {
        @org.jetbrains.annotations.Nullable()
        private final com.google.android.gms.ads.nativead.NativeAd nativeAd = null;
        
        public AdItem(@org.jetbrains.annotations.Nullable()
        com.google.android.gms.ads.nativead.NativeAd nativeAd) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.google.android.gms.ads.nativead.NativeAd getNativeAd() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.google.android.gms.ads.nativead.NativeAd component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem.AdItem copy(@org.jetbrains.annotations.Nullable()
        com.google.android.gms.ads.nativead.NativeAd nativeAd) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem$JunkItemWrapper;", "Lcom/smartphonecleaner/pro/presentation/ui/cleaner/ResultsListItem;", "junkItem", "Lcom/smartphonecleaner/pro/domain/model/JunkItem;", "(Lcom/smartphonecleaner/pro/domain/model/JunkItem;)V", "getJunkItem", "()Lcom/smartphonecleaner/pro/domain/model/JunkItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class JunkItemWrapper extends com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem {
        @org.jetbrains.annotations.NotNull()
        private final com.smartphonecleaner.pro.domain.model.JunkItem junkItem = null;
        
        public JunkItemWrapper(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.domain.model.JunkItem junkItem) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.domain.model.JunkItem getJunkItem() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.domain.model.JunkItem component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.smartphonecleaner.pro.presentation.ui.cleaner.ResultsListItem.JunkItemWrapper copy(@org.jetbrains.annotations.NotNull()
        com.smartphonecleaner.pro.domain.model.JunkItem junkItem) {
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
}