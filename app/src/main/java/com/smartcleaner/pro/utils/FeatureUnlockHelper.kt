package com.smartcleaner.pro.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.smartcleaner.pro.data.remote.AdManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeatureUnlockHelper @Inject constructor(
    @ApplicationContext private val context: Context,
    private val adManager: AdManager
) {
    companion object {
        private const val TAG = "FeatureUnlockHelper"
        private const val PREFS_NAME = "FeatureUnlockPrefs"
        private const val FEATURE_DEEP_CLEAN = "deep_clean"
        private const val FEATURE_DUPLICATE_PHOTO_FINDER = "duplicate_photo_finder"
        private const val FEATURE_PRIVACY_ERASER_PRO = "privacy_eraser_pro"
        private const val FEATURE_CUSTOM_THEMES = "custom_themes"
        private const val FEATURE_CLOUD_BACKUP = "cloud_backup"
        private const val UNLOCK_DURATION_MS = 24 * 60 * 60 * 1000L // 24 hours
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    init {
        // Set up reward callback from AdManager
        adManager.onRewardedEarned = {
            Log.d(TAG, "Reward earned - unlocking features")
            // This will be handled by specific feature unlock methods
        }
        
        // Set up feature unlock request callback
        adManager.onFeatureUnlockRequest = { feature ->
            unlockFeature(feature)
            trackFeatureUsage(feature, "rewarded_unlocked")
        }
    }

    // Feature unlock methods
    fun deepCleanUnlocked(): Boolean {
        return isFeatureUnlocked(FEATURE_DEEP_CLEAN)
    }

    fun duplicatePhotoFinderUnlocked(): Boolean {
        return isFeatureUnlocked(FEATURE_DUPLICATE_PHOTO_FINDER)
    }

    fun privacyEraserProUnlocked(): Boolean {
        return isFeatureUnlocked(FEATURE_PRIVACY_ERASER_PRO)
    }

    fun customThemesUnlocked(): Boolean {
        return isFeatureUnlocked(FEATURE_CUSTOM_THEMES)
    }

    fun cloudBackupUnlocked(): Boolean {
        return isFeatureUnlocked(FEATURE_CLOUD_BACKUP)
    }

    // Method to unlock a feature for 24 hours
    fun unlockFeature(feature: String): Boolean {
        val currentTime = System.currentTimeMillis()
        val expirationTime = currentTime + UNLOCK_DURATION_MS
        
        return try {
            with(sharedPreferences.edit()) {
                putLong("${feature}_expiration", expirationTime)
                apply()
            }
            Log.d(TAG, "Feature $feature unlocked until $expirationTime")
            trackFeatureUsage(feature, "unlocked")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Failed to unlock feature $feature: ${e.message}")
            false
        }
    }

    // Method to check if a feature is currently unlocked
    private fun isFeatureUnlocked(feature: String): Boolean {
        val expirationTime = sharedPreferences.getLong("${feature}_expiration", 0L)
        val currentTime = System.currentTimeMillis()
        
        if (expirationTime > currentTime) {
            // Feature is still unlocked
            return true
        } else if (expirationTime > 0) {
            // Feature was unlocked but has expired
            // Clean up the expired entry
            sharedPreferences.edit().remove("${feature}_expiration").apply()
            return false
        }
        
        return false
    }

    // Method to get remaining time for a feature unlock in milliseconds
    fun getRemainingTime(feature: String): Long {
        val expirationTime = sharedPreferences.getLong("${feature}_expiration", 0L)
        val currentTime = System.currentTimeMillis()
        
        return if (expirationTime > currentTime) {
            expirationTime - currentTime
        } else {
            0L
        }
    }

    // Method to clear all unlocked features (for testing or user request)
    fun clearAllUnlockedFeatures() {
        try {
            with(sharedPreferences.edit()) {
                remove("${FEATURE_DEEP_CLEAN}_expiration")
                remove("${FEATURE_DUPLICATE_PHOTO_FINDER}_expiration")
                remove("${FEATURE_PRIVACY_ERASER_PRO}_expiration")
                remove("${FEATURE_CUSTOM_THEMES}_expiration")
                remove("${FEATURE_CLOUD_BACKUP}_expiration")
                apply()
            }
            Log.d(TAG, "All unlocked features cleared")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to clear unlocked features: ${e.message}")
        }
    }

    // Analytics tracking for feature usage
    private fun trackFeatureUsage(feature: String, action: String) {
        // In a real implementation, this would integrate with your analytics service
        // For now, we'll just log it
        Log.d(TAG, "Feature analytics: $feature - $action")
        
        // Example of what you might do with a real analytics service:
        // Analytics.trackEvent("feature_$action", mapOf(
        //     "feature_name" to feature,
        //     "timestamp" to System.currentTimeMillis().toString()
        // ))
    }

    // Convenience methods for unlocking specific features
    fun unlockDeepClean(): Boolean {
        return unlockFeature(FEATURE_DEEP_CLEAN)
    }

    fun unlockDuplicatePhotoFinder(): Boolean {
        return unlockFeature(FEATURE_DUPLICATE_PHOTO_FINDER)
    }

    fun unlockPrivacyEraserPro(): Boolean {
        return unlockFeature(FEATURE_PRIVACY_ERASER_PRO)
    }

    fun unlockCustomThemes(): Boolean {
        return unlockFeature(FEATURE_CUSTOM_THEMES)
    }

    fun unlockCloudBackup(): Boolean {
        return unlockFeature(FEATURE_CLOUD_BACKUP)
    }

    // Method to check if any feature is currently unlocked
    fun hasAnyFeatureUnlocked(): Boolean {
        return deepCleanUnlocked() || 
               duplicatePhotoFinderUnlocked() || 
               privacyEraserProUnlocked() || 
               customThemesUnlocked() || 
               cloudBackupUnlocked()
    }

    // Method to get all currently unlocked features
    fun getUnlockedFeatures(): List<String> {
        val unlockedFeatures = mutableListOf<String>()
        
        if (deepCleanUnlocked()) unlockedFeatures.add(FEATURE_DEEP_CLEAN)
        if (duplicatePhotoFinderUnlocked()) unlockedFeatures.add(FEATURE_DUPLICATE_PHOTO_FINDER)
        if (privacyEraserProUnlocked()) unlockedFeatures.add(FEATURE_PRIVACY_ERASER_PRO)
        if (customThemesUnlocked()) unlockedFeatures.add(FEATURE_CUSTOM_THEMES)
        if (cloudBackupUnlocked()) unlockedFeatures.add(FEATURE_CLOUD_BACKUP)
        
        return unlockedFeatures
    }

    // Method to format remaining time as a human-readable string
    fun formatRemainingTime(remainingMs: Long): String {
        if (remainingMs <= 0) return "Expired"
        
        val hours = remainingMs / (60 * 60 * 1000)
        val minutes = (remainingMs % (60 * 60 * 1000)) / (60 * 1000)
        
        return when {
            hours > 0 -> "${hours}h ${minutes}m remaining"
            minutes > 0 -> "${minutes}m remaining"
            else -> "Less than a minute remaining"
        }
    }

    // Integration with AdManager for reward callbacks
    fun setupRewardedAdCallback(featureToUnlock: String) {
        adManager.onRewardedEarned = {
            when (featureToUnlock) {
                FEATURE_DEEP_CLEAN -> unlockDeepClean()
                FEATURE_DUPLICATE_PHOTO_FINDER -> unlockDuplicatePhotoFinder()
                FEATURE_PRIVACY_ERASER_PRO -> unlockPrivacyEraserPro()
                FEATURE_CUSTOM_THEMES -> unlockCustomThemes()
                FEATURE_CLOUD_BACKUP -> unlockCloudBackup()
                else -> Log.w(TAG, "Unknown feature to unlock: $featureToUnlock")
            }
            trackFeatureUsage(featureToUnlock, "rewarded_unlocked")
        }
    }

    // Method to request feature unlock via rewarded ad
    fun requestFeatureUnlockViaRewardedAd(feature: String, activity: android.app.Activity,
                                         onAdClosed: (() -> Unit)? = null) {
        // Set up the callback for this specific feature
        setupRewardedAdCallback(feature)
        
        // Show the rewarded ad
        adManager.showRewardedAd(activity, onAdClosed)
    }

    // Cleanup method
    fun cleanup() {
        // Clean up any expired features
        listOf(FEATURE_DEEP_CLEAN, FEATURE_DUPLICATE_PHOTO_FINDER, FEATURE_PRIVACY_ERASER_PRO, 
               FEATURE_CUSTOM_THEMES, FEATURE_CLOUD_BACKUP).forEach { feature ->
            isFeatureUnlocked(feature) // This will clean up expired entries
        }
    }
}