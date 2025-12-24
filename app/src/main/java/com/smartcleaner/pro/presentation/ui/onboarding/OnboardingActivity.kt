package com.smartcleaner.pro.presentation.ui.onboarding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.smartcleaner.pro.MainActivity
import com.smartcleaner.pro.R
import com.smartcleaner.pro.databinding.ActivityOnboardingBinding
import com.smartcleaner.pro.utils.PermissionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: OnboardingAdapter

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var permissionManager: PermissionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check if onboarding is already completed
        if (isOnboardingCompleted()) {
            startMainActivity()
            return
        }

        setupViewPager()
        setupButtons()
    }

    private fun setupViewPager() {
        viewPager = binding.viewPager
        adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, viewPager) { _, _ -> }.attach()
    }

    private fun setupButtons() {
        binding.btnNext.setOnClickListener {
            if (viewPager.currentItem < adapter.itemCount - 1) {
                viewPager.currentItem = viewPager.currentItem + 1
            } else {
                completeOnboarding()
            }
        }

        binding.btnSkip.setOnClickListener {
            completeOnboarding()
        }
    }

    private fun completeOnboarding() {
        sharedPreferences.edit().putBoolean("onboarding_completed", true).apply()
        startMainActivity()
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun isOnboardingCompleted(): Boolean {
        return sharedPreferences.getBoolean("onboarding_completed", false)
    }
}