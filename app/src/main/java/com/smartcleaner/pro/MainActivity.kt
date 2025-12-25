package com.smartcleaner.pro

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.smartcleaner.pro.data.remote.AdManager
import com.smartcleaner.pro.databinding.ActivityMainBinding
import com.smartcleaner.pro.presentation.ui.onboarding.OnboardingActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var adManager: AdManager

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check if onboarding is completed
        if (!isOnboardingCompleted()) {
            startOnboardingActivity()
            return
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load banner ad
        val adView = adManager.createBannerAd()
        binding.adContainer.addView(adView)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)

        // Show interstitial on navigation changes
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Show interstitial ad on feature switch (not on initial load)
            if (destination.id != navController.graph.startDestinationId) {
                adManager.showInterstitialAd(this)
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
}