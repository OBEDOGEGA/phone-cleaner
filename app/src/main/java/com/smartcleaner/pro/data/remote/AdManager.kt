package com.smartcleaner.pro.data.remote

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.*
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
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
class AdManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val adImpressionDao: AdImpressionDao
) : LifecycleObserver {

    private val TAG = "AdManager"

    // Ad unit IDs
    private val bannerAdUnitId = context.getString(R.string.admob_banner_ad_unit_id)
    private val interstitialAdUnitId = context.getString(R.string.admob_interstitial_ad_unit_id)
    private val rewardedAdUnitId = context.getString(R.string.admob_rewarded_ad_unit_id)
    private val rewardedInterstitialAdUnitId = context.getString(R.string.admob_rewarded_interstitial_ad_unit_id)
    private val nativeAdUnitId = context.getString(R.string.admob_native_ad_unit_id)
    private val appOpenAdUnitId = context.getString(R.string.admob_app_open_ad_unit_id)

    // Ad instances
    private var bannerAdView: AdView? = null
    private var interstitialAd: InterstitialAd? = null
    private var rewardedAd: RewardedAd? = null
    private var rewardedInterstitialAd: RewardedInterstitialAd? = null
    private var nativeAd: NativeAd? = null
    private var appOpenAd: AppOpenAd? = null

    // Frequency capping for interstitial (3 per session, 3-minute cooldown)
    private var sessionInterstitialCount = 0
    private var lastInterstitialShowTime: Long = 0
    private val interstitialCooldownMs = 3 * 60 * 1000L // 3 minutes
    private val maxInterstitialPerSession = 3

    // App open ad state
    private var isLoadingAppOpenAd = false
    private var isShowingAppOpenAd = false

    // Callbacks
    var onRewardedEarned: (() -> Unit)? = null
    var onFeatureUnlockRequest: ((String) -> Unit)? = null

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

    init {
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        // Pre-load ads
        loadInterstitialAd()
        loadRewardedAd()
        loadRewardedInterstitialAd()
        loadNativeAd()
        loadAppOpenAd()
    }

    // Banner Ad Methods
    fun createBannerAd(containerWidthDp: Int = 320): AdView {
        bannerAdView = AdView(context).apply {
            adUnitId = bannerAdUnitId
            adSize = AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, containerWidthDp)
            loadAd(AdRequest.Builder().build())
        }
        return bannerAdView!!
    }

    fun destroyBannerAd() {
        bannerAdView?.destroy()
        bannerAdView = null
    }

    // Interstitial Ad Methods
    private fun loadInterstitialAd() {
        InterstitialAd.load(
            context,
            interstitialAdUnitId,
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    Log.d(TAG, "Interstitial ad loaded")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "Interstitial ad failed to load: ${error.message}")
                    interstitialAd = null
                }
            }
        )
    }

    fun showInterstitialAd(activity: Activity, onAdClosed: (() -> Unit)? = null) {
        val currentTime = System.currentTimeMillis()
        if (sessionInterstitialCount >= maxInterstitialPerSession ||
            (lastInterstitialShowTime > 0 && currentTime - lastInterstitialShowTime < interstitialCooldownMs)) {
            Log.d(TAG, "Interstitial ad capped: count=$sessionInterstitialCount, cooldown=${currentTime - lastInterstitialShowTime < interstitialCooldownMs}")
            onAdClosed?.invoke()
            return
        }

        interstitialAd?.let { ad ->
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Interstitial ad dismissed")
                    sessionInterstitialCount++
                    lastInterstitialShowTime = System.currentTimeMillis()
                    loadInterstitialAd() // Pre-load next ad
                    onAdClosed?.invoke()
                }

                override fun onAdFailedToShowFullScreenContent(error: AdError) {
                    Log.e(TAG, "Interstitial ad failed to show: ${error.message}")
                    onAdClosed?.invoke()
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "Interstitial ad showed")
                    trackAdImpression(interstitialAdUnitId, "shown")
                    interstitialAd = null
                }
            }
            ad.show(activity)
        } ?: run {
            Log.d(TAG, "Interstitial ad not ready")
            onAdClosed?.invoke()
        }
    }

    // Rewarded Ad Methods
    private fun loadRewardedAd() {
        RewardedAd.load(
            context,
            rewardedAdUnitId,
            AdRequest.Builder().build(),
            object : RewardedAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedAd) {
                    rewardedAd = ad
                    Log.d(TAG, "Rewarded ad loaded")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "Rewarded ad failed to load: ${error.message}")
                    rewardedAd = null
                }
            }
        )
    }

    private fun loadRewardedInterstitialAd() {
        RewardedInterstitialAd.load(
            context,
            rewardedInterstitialAdUnitId,
            AdRequest.Builder().build(),
            object : RewardedInterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedInterstitialAd) {
                    rewardedInterstitialAd = ad
                    Log.d(TAG, "Rewarded interstitial ad loaded")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "Rewarded interstitial ad failed to load: ${error.message}")
                    rewardedInterstitialAd = null
                }
            }
        )
    }

    fun showRewardedAd(activity: Activity, onAdClosed: (() -> Unit)? = null) {
        val adToShow = rewardedAd ?: rewardedInterstitialAd
        val adUnitId = if (rewardedAd != null) rewardedAdUnitId else rewardedInterstitialAdUnitId

        adToShow?.let { ad ->
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Rewarded ad dismissed")
                    if (rewardedAd != null) {
                        loadRewardedAd()
                    } else {
                        loadRewardedInterstitialAd()
                    }
                    onAdClosed?.invoke()
                }

                override fun onAdFailedToShowFullScreenContent(error: AdError) {
                    Log.e(TAG, "Rewarded ad failed to show: ${error.message}")
                    onAdClosed?.invoke()
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "Rewarded ad showed")
                    trackAdImpression(adUnitId, "shown")
                    if (rewardedAd != null) {
                        rewardedAd = null
                    } else {
                        rewardedInterstitialAd = null
                    }
                }
            }

            ad.show(activity) { rewardItem ->
                Log.d(TAG, "User earned reward: ${rewardItem.amount} ${rewardItem.type}")
                onRewardedEarned?.invoke()
            }
        } ?: run {
            Log.d(TAG, "Rewarded ad not ready")
            onAdClosed?.invoke()
        }
    }

    // Native Ad Methods
    private fun loadNativeAd() {
        val adLoader = AdLoader.Builder(context, nativeAdUnitId)
            .forNativeAd { ad ->
                nativeAd = ad
                Log.d(TAG, "Native ad loaded")
            }
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "Native ad failed to load: ${error.message}")
                    nativeAd = null
                }
            })
            .withNativeAdOptions(
                NativeAdOptions.Builder()
                    .setRequestMultipleImages(false)
                    .build()
            )
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }

    // App Open Ad Methods
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        showAppOpenAdIfAvailable()
    }

    private fun loadAppOpenAd() {
        if (isLoadingAppOpenAd || isAppOpenAdAvailable()) {
            return
        }

        isLoadingAppOpenAd = true
        AppOpenAd.load(
            context,
            appOpenAdUnitId,
            AdRequest.Builder().build(),
            object : AppOpenAd.AppOpenAdLoadCallback() {
                override fun onAdLoaded(ad: AppOpenAd) {
                    appOpenAd = ad
                    isLoadingAppOpenAd = false
                    Log.d(TAG, "App open ad loaded")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "App open ad failed to load: ${error.message}")
                    isLoadingAppOpenAd = false
                    appOpenAd = null
                }
            }
        )
    }

    private fun showAppOpenAdIfAvailable() {
        if (!isShowingAppOpenAd && isAppOpenAdAvailable()) {
            Log.d(TAG, "Will show app open ad")
            val fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "App open ad dismissed")
                    appOpenAd = null
                    isShowingAppOpenAd = false
                    loadAppOpenAd()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    Log.e(TAG, "App open ad failed to show: ${adError.message}")
                    appOpenAd = null
                    isShowingAppOpenAd = false
                    loadAppOpenAd()
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "App open ad showed")
                    trackAdImpression(appOpenAdUnitId, "shown")
                    isShowingAppOpenAd = true
                }
            }

            appOpenAd?.fullScreenContentCallback = fullScreenContentCallback
            appOpenAd?.show(context as Activity)
        } else {
            Log.d(TAG, "App open ad is not ready yet.")
            if (!isLoadingAppOpenAd) {
                loadAppOpenAd()
            }
        }
    }

    private fun isAppOpenAdAvailable(): Boolean {
        return appOpenAd != null
    }

    fun getAppOpenAd(): AppOpenAd? = appOpenAd

    fun getNativeAd(): NativeAd? = nativeAd

    fun populateNativeAdView(nativeAdView: NativeAdView, nativeAd: NativeAd) {
        // Track impression
        trackAdImpression(nativeAdUnitId, "shown")

        // Set the media view (if available)
        nativeAdView.mediaView = nativeAdView.findViewById(R.id.ad_media)

        // Set other ad assets
        nativeAdView.headlineView = nativeAdView.findViewById(R.id.ad_headline)
        nativeAdView.bodyView = nativeAdView.findViewById(R.id.ad_body)
        nativeAdView.callToActionView = nativeAdView.findViewById(R.id.ad_call_to_action)
        nativeAdView.iconView = nativeAdView.findViewById(R.id.ad_app_icon)
        nativeAdView.advertiserView = nativeAdView.findViewById(R.id.ad_advertiser)

        // Populate the ad assets
        (nativeAdView.headlineView as? TextView)?.text = nativeAd.headline
        (nativeAdView.bodyView as? TextView)?.text = nativeAd.body
        (nativeAdView.callToActionView as? Button)?.text = nativeAd.callToAction
        (nativeAdView.advertiserView as? TextView)?.text = nativeAd.advertiser

        nativeAdView.iconView?.let { view ->
            if (nativeAd.icon != null) {
                (view as? ImageView)?.setImageDrawable(nativeAd.icon?.drawable)
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }
        }

        // Set the native ad
        nativeAdView.setNativeAd(nativeAd)
    }

    // Cleanup
    fun destroy() {
        destroyBannerAd()
        interstitialAd = null
        rewardedAd = null
        rewardedInterstitialAd = null
        nativeAd?.destroy()
        nativeAd = null
        appOpenAd = null
        ProcessLifecycleOwner.get().lifecycle.removeObserver(this)
    }
}