package com.smartcleaner.pro.data.remote

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
import com.smartcleaner.pro.R
import com.smartcleaner.pro.data.local.AdImpression
import com.smartcleaner.pro.data.local.AdImpressionDao
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppOpenAdManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val adImpressionDao: AdImpressionDao,
    private val consentManager: ConsentManager
) : LifecycleObserver {

    private val TAG = "AppOpenAdManager"

    private val appOpenAdUnitId = context.getString(R.string.admob_app_open_ad_unit_id)
    private var appOpenAd: AppOpenAd? = null
    private var isLoadingAd = false
    private var isShowingAd = false
    private var lastAppOpenTime: Long = 0L
    private val appOpenCooldownMs = 30 * 60 * 1000L // 30 minutes

    init {
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        loadAd()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        showAdIfAvailable()
        Log.d(TAG, "onStart")
    }

    private fun loadAd() {
        if (isLoadingAd || isAdAvailable()) {
            return
        }

        isLoadingAd = true
        val request = AdRequest.Builder().build()
        AppOpenAd.load(
            context, appOpenAdUnitId, request,
            object : AppOpenAdLoadCallback() {
                override fun onAdLoaded(ad: AppOpenAd) {
                    Log.d(TAG, "App open ad loaded")
                    appOpenAd = ad
                    isLoadingAd = false
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.e(TAG, "App open ad failed to load: ${loadAdError.message}")
                    isLoadingAd = false
                }
            }
        )
    }

    private fun showAdIfAvailable() {
        val currentTime = System.currentTimeMillis()
        if (!isShowingAd && isAdAvailable() && (currentTime - lastAppOpenTime > appOpenCooldownMs)) {
            Log.d(TAG, "Will show app open ad.")
            val fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "App open ad dismissed")
                    appOpenAd = null
                    isShowingAd = false
                    lastAppOpenTime = System.currentTimeMillis()
                    loadAd()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    Log.e(TAG, "App open ad failed to show: ${adError.message}")
                    appOpenAd = null
                    isShowingAd = false
                    loadAd()
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "App open ad showed")
                    trackAdImpression(appOpenAdUnitId, "shown")
                    isShowingAd = true
                }
            }

            appOpenAd?.fullScreenContentCallback = fullScreenContentCallback
            appOpenAd?.show(context as Activity)
        } else {
            Log.d(TAG, "App open ad is not ready yet or cooldown active.")
            if (!isLoadingAd) {
                loadAd()
            }
        }
    }

    private fun isAdAvailable(): Boolean {
        return appOpenAd != null
    }

    private fun trackAdImpression(adId: String, type: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val impression = AdImpression(
                adId = adId,
                timestamp = System.currentTimeMillis(),
                impressionType = type
            )
            adImpressionDao.insert(impression)
        }
    }
}