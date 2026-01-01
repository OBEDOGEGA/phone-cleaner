package com.smartphonecleaner.pro.utils;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/smartphonecleaner/pro/utils/NotificationManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "notificationManager", "Landroid/app/NotificationManager;", "createNotificationChannel", "", "formatSize", "", "bytes", "", "showCleaningCompleteNotification", "cleanedSize", "filesCleaned", "", "showCleaningInProgressNotification", "showScheduledCleaningNotification", "Companion", "app_debug"})
public final class NotificationManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CLEANING_CHANNEL_ID = "cleaning_channel";
    private static final int CLEANING_NOTIFICATION_ID = 1001;
    private static final int CLEANING_COMPLETE_NOTIFICATION_ID = 1002;
    @org.jetbrains.annotations.NotNull()
    private final android.app.NotificationManager notificationManager = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.smartphonecleaner.pro.utils.NotificationManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public NotificationManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final void createNotificationChannel() {
    }
    
    public final void showCleaningInProgressNotification(long cleanedSize) {
    }
    
    public final void showCleaningCompleteNotification(long cleanedSize, int filesCleaned) {
    }
    
    public final void showScheduledCleaningNotification() {
    }
    
    private final java.lang.String formatSize(long bytes) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/smartphonecleaner/pro/utils/NotificationManager$Companion;", "", "()V", "CLEANING_CHANNEL_ID", "", "CLEANING_COMPLETE_NOTIFICATION_ID", "", "CLEANING_NOTIFICATION_ID", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}