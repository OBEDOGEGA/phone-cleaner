package com.smartcleaner.pro

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.smartcleaner.pro.data.remote.AppOpenAdManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class SmartCleanerApp : Application() {

    @Inject
    lateinit var appOpenAdManager: AppOpenAdManager

    override fun onCreate() {
        super.onCreate()

        // Initialize AdMob
        MobileAds.initialize(this) { initializationStatus ->
            // AdMob initialization complete
        }

        // AppOpenAdManager is injected and registers itself with ProcessLifecycleOwner
    }
}