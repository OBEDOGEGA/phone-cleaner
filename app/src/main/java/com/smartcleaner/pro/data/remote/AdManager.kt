package com.smartcleaner.pro.data.remote

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.*
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
import com.smartcleaner.pro.R
import com.smartcleaner.pro.data.local.AdImpression
import com.smartcleaner.pro.data.local.AdImpressionDao
import com.smartcleaner.pro.data.remote.ConsentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val adImpressionDao: AdImpressionDao,
    private val consentManager: ConsentManager
) : LifecycleObserver {

    companion object {
        private const val MAX_RETRIES = 3
        private const val INITIAL_RETRY_DELAY_MS = 1000L
    }

    private val TAG = "AdManager"

    // Retry counters
    private var interstitialRetryCount = 0
    private var rewardedRetryCount = 0
    private var rewardedInterstitialRetryCount = 0
    private var nativeRetryCount = 0
    private var appOpenRetryCount = 0
    private var bannerRetryCount = 0

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

    fun buildAdRequest(): AdRequest = AdRequest.Builder().build()

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

        // Log initial state
        Log.d(TAG, "AdManager initialized - rewarded ad loading started")
    }

    // Banner Ad Methods
    fun createBannerAd(containerWidthDp: Int = 320): AdView {
        bannerAdView = AdView(context).apply {
            adUnitId = bannerAdUnitId
            setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, containerWidthDp))
            adListener = object : AdListener() {
                override fun onAdLoaded() {
                    bannerRetryCount = 0
                    Log.d(TAG, "Banner ad loaded")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "Banner ad failed to load (attempt ${bannerRetryCount + 1}/${MAX_RETRIES}): ${error.message}")
                    if (bannerRetryCount < MAX_RETRIES) {
                        bannerRetryCount++
                        val delay = INITIAL_RETRY_DELAY_MS * (1L shl (bannerRetryCount - 1))
                        CoroutineScope(Dispatchers.Main).launch {
                            kotlinx.coroutines.delay(delay)
                            bannerAdView?.loadAd(buildAdRequest())
                        }
                    } else {
                        bannerRetryCount = 0
                    }
                }
            }
            loadAd(buildAdRequest())
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
            buildAdRequest(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    interstitialRetryCount = 0
                    Log.d(TAG, "Interstitial ad loaded")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "Interstitial ad failed to load (attempt ${interstitialRetryCount + 1}/${MAX_RETRIES}): ${error.message}")
                    interstitialAd = null
                    if (interstitialRetryCount < MAX_RETRIES) {
                        interstitialRetryCount++
                        val delay = INITIAL_RETRY_DELAY_MS * (1L shl (interstitialRetryCount - 1))
                        CoroutineScope(Dispatchers.Main).launch {
                            kotlinx.coroutines.delay(delay)
                            loadInterstitialAd()
                        }
                    } else {
                        interstitialRetryCount = 0
                    }
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

    fun tryShowInterstitialAfterClean(activity: Activity, savedSize: Long) {
        if (savedSize > 50L * 1024 * 1024) { // 50 MB
            showInterstitialAd(activity)
        }
    }

    // Rewarded Ad Methods
    private fun loadRewardedAd() {
        RewardedAd.load(
            context,
            rewardedAdUnitId,
            buildAdRequest(),
            object : RewardedAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedAd) {
                    rewardedAd = ad
                    rewardedRetryCount = 0
                    Log.d(TAG, "Rewarded ad loaded")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "Rewarded ad failed to load (attempt ${rewardedRetryCount + 1}/${MAX_RETRIES}): ${error.message}")
                    rewardedAd = null
                    if (rewardedRetryCount < MAX_RETRIES) {
                        rewardedRetryCount++
                        val delay = INITIAL_RETRY_DELAY_MS * (1L shl (rewardedRetryCount - 1))
                        CoroutineScope(Dispatchers.Main).launch {
                            kotlinx.coroutines.delay(delay)
                            loadRewardedAd()
                        }
                    } else {
                        rewardedRetryCount = 0
                    }
                }
            }
        )
    }

    private fun loadRewardedInterstitialAd() {
        RewardedInterstitialAd.load(
            context,
            rewardedInterstitialAdUnitId,
            buildAdRequest(),
            object : RewardedInterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedInterstitialAd) {
                    rewardedInterstitialAd = ad
                    rewardedInterstitialRetryCount = 0
                    Log.d(TAG, "Rewarded interstitial ad loaded")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "Rewarded interstitial ad failed to load (attempt ${rewardedInterstitialRetryCount + 1}/${MAX_RETRIES}): ${error.message}")
                    rewardedInterstitialAd = null
                    if (rewardedInterstitialRetryCount < MAX_RETRIES) {
                        rewardedInterstitialRetryCount++
                        val delay = INITIAL_RETRY_DELAY_MS * (1L shl (rewardedInterstitialRetryCount - 1))
                        CoroutineScope(Dispatchers.Main).launch {
                            kotlinx.coroutines.delay(delay)
                            loadRewardedInterstitialAd()
                        }
                    } else {
                        rewardedInterstitialRetryCount = 0
                    }
                }
            }
        )
    }

    fun showRewardedAd(activity: Activity, onAdClosed: (() -> Unit)? = null) {
        val adToShow = rewardedAd ?: rewardedInterstitialAd
        val adUnitId = if (rewardedAd != null) rewardedAdUnitId else rewardedInterstitialAdUnitId
        val adType = if (rewardedAd != null) "RewardedAd" else "RewardedInterstitialAd"

        Log.d(TAG, "Attempting to show rewarded ad - Type: $adType, Available: ${adToShow != null}")

        adToShow?.let { ad ->
            val callback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "$adType dismissed - reloading ad")
                    if (rewardedAd != null) {
                        loadRewardedAd()
                    } else {
                        loadRewardedInterstitialAd()
                    }
                    onAdClosed?.invoke()
                }

                override fun onAdFailedToShowFullScreenContent(error: AdError) {
                    Log.e(TAG, "$adType failed to show: ${error.message} (code: ${error.code})")
                    onAdClosed?.invoke()
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "$adType showed successfully")
                    trackAdImpression(adUnitId, "shown")
                    if (rewardedAd != null) {
                        rewardedAd = null
                    } else {
                        rewardedInterstitialAd = null
                    }
                }
            }

            when (ad) {
                is RewardedAd -> {
                    ad.fullScreenContentCallback = callback
                    Log.d(TAG, "Showing RewardedAd")
                    ad.show(activity) { rewardItem ->
                        Log.d(TAG, "User earned reward: ${rewardItem.amount} ${rewardItem.type} - invoking callback")
                        onRewardedEarned?.invoke()
                    }
                }
                is RewardedInterstitialAd -> {
                    ad.fullScreenContentCallback = callback
                    Log.d(TAG, "Showing RewardedInterstitialAd")
                    ad.show(activity) { rewardItem ->
                        Log.d(TAG, "User earned reward: ${rewardItem.amount} ${rewardItem.type} - invoking callback")
                        onRewardedEarned?.invoke()
                    }
                }
            }
        } ?: run {
            Log.w(TAG, "No rewarded ad available - rewardedAd: ${rewardedAd != null}, rewardedInterstitialAd: ${rewardedInterstitialAd != null}")
            onAdClosed?.invoke()
        }
    }

    // Native Ad Methods
    private fun loadNativeAd() {
        Log.d(TAG, "Loading native ad, current retry count: $nativeRetryCount")
        val adLoader = AdLoader.Builder(context, nativeAdUnitId)
            .forNativeAd { ad ->
                nativeAd = ad
                nativeRetryCount = 0
                Log.d(TAG, "Native ad loaded successfully")
            }
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "Native ad failed to load (attempt ${nativeRetryCount + 1}/${MAX_RETRIES}): ${error.message}")
                    nativeAd = null
                    if (nativeRetryCount < MAX_RETRIES) {
                        nativeRetryCount++
                        val delay = INITIAL_RETRY_DELAY_MS * (1L shl (nativeRetryCount - 1))
                        Log.d(TAG, "Retrying native ad load in $delay ms")
                        CoroutineScope(Dispatchers.Main).launch {
                            kotlinx.coroutines.delay(delay)
                            loadNativeAd()
                        }
                    } else {
                        Log.e(TAG, "Native ad failed to load after $MAX_RETRIES attempts")
                        nativeRetryCount = 0
                    }
                }
            })
            .withNativeAdOptions(
                NativeAdOptions.Builder()
                    .setRequestMultipleImages(false)
                    .build()
            )
            .build()

        adLoader.loadAd(buildAdRequest())
    }

    // App Open Ad Methods
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
            buildAdRequest(),
            object : AppOpenAdLoadCallback() {
                override fun onAdLoaded(ad: AppOpenAd) {
                    appOpenAd = ad
                    isLoadingAppOpenAd = false
                    appOpenRetryCount = 0
                    Log.d(TAG, "App open ad loaded")
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.e(TAG, "App open ad failed to load (attempt ${appOpenRetryCount + 1}/${MAX_RETRIES}): ${error.message}")
                    isLoadingAppOpenAd = false
                    appOpenAd = null
                    if (appOpenRetryCount < MAX_RETRIES) {
                        appOpenRetryCount++
                        val delay = INITIAL_RETRY_DELAY_MS * (1L shl (appOpenRetryCount - 1))
                        CoroutineScope(Dispatchers.Main).launch {
                            kotlinx.coroutines.delay(delay)
                            loadAppOpenAd()
                        }
                    } else {
                        appOpenRetryCount = 0
                    }
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

    fun isRewardedAdLoaded(): Boolean = rewardedAd != null || rewardedInterstitialAd != null

    fun getNativeAd(): NativeAd? = nativeAd

    fun populateNativeAdView(nativeAdView: NativeAdView, nativeAd: NativeAd) {
        Log.d(TAG, "Populating native ad view")
        // Track impression
        trackAdImpression(nativeAdUnitId, "shown")

        // Set the media view (if available) - commented out as this layout doesn't include media
        // nativeAdView.mediaView = nativeAdView.findViewById(R.id.ad_media)

        // Set other ad assets
        nativeAdView.headlineView = nativeAdView.findViewById(R.id.ad_headline)
        nativeAdView.bodyView = nativeAdView.findViewById(R.id.ad_body)
        nativeAdView.callToActionView = nativeAdView.findViewById(R.id.ad_call_to_action)
        nativeAdView.iconView = nativeAdView.findViewById(R.id.ad_app_icon)
        nativeAdView.advertiserView = nativeAdView.findViewById(R.id.ad_advertiser)

        Log.d(TAG, "Native ad assets - headline: ${nativeAd.headline}, body: ${nativeAd.body}, callToAction: ${nativeAd.callToAction}, advertiser: ${nativeAd.advertiser}")

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
        Log.d(TAG, "Native ad view populated successfully")
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