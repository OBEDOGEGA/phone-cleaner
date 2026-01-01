package com.smartphonecleaner.pro

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.smartphonecleaner.pro.data.remote.AdManager
import com.smartphonecleaner.pro.data.remote.ConsentManager
import com.smartphonecleaner.pro.databinding.ActivityMainBinding
import com.smartphonecleaner.pro.presentation.ui.onboarding.OnboardingActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var adManager: AdManager

    @Inject
    lateinit var consentManager: ConsentManager

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private lateinit var adView: AdView
    private lateinit var refreshHandler: Handler
    private lateinit var refreshRunnable: Runnable

    private var tabSwitchCount = 0
    private var sessionStartTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if onboarding is completed
        if (!isOnboardingCompleted()) {
            startOnboardingActivity()
            return
        }

        sessionStartTime = System.currentTimeMillis()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize GDPR consent
        consentManager.initializeConsent(this) {
            // Consent initialization complete, now load ads
            loadAds()
        }
    }

    private fun loadAds() {
        // Load banner ad
        adView = adManager.createBannerAd()
        binding.adContainer.addView(adView)

        // Set up banner refresh every 60 seconds
        refreshHandler = Handler(Looper.getMainLooper())
        refreshRunnable = Runnable {
            adView.loadAd(adManager.buildAdRequest())
            refreshHandler.postDelayed(refreshRunnable, 60000)
        }
        refreshHandler.postDelayed(refreshRunnable, 60000)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)

        // Show interstitial on navigation changes
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Show interstitial ad on feature switch (not on initial load)
            if (destination.id != navController.graph.startDestinationId) {
                tabSwitchCount++
                if (tabSwitchCount == 3) {
                    adManager.showInterstitialAd(this)
                    tabSwitchCount = 0 // Reset for next cycle
                }
            }
        }
    }

    private fun isOnboardingCompleted(): Boolean {
        return sharedPreferences.getBoolean("onboarding_completed", false)
    }

    private fun startOnboardingActivity() {
        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun onBackPressed() {
        if (System.currentTimeMillis() - sessionStartTime > 60000) {
            adManager.showInterstitialAd(this) { super.onBackPressed() }
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        refreshHandler.removeCallbacks(refreshRunnable)
        adView.destroy()
    }
}