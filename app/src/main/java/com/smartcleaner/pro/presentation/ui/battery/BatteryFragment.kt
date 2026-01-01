package com.smartcleaner.pro.presentation.ui.battery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.smartcleaner.pro.R
import com.smartcleaner.pro.data.remote.AdManager
import com.smartcleaner.pro.databinding.FragmentBatteryBinding
import com.smartcleaner.pro.presentation.viewmodel.BatteryViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BatteryFragment : Fragment() {

    private var _binding: FragmentBatteryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BatteryViewModel by viewModels()

    @Inject
    lateinit var adManager: AdManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        android.util.Log.d("BatteryFragment", "onCreateView called")
        _binding = FragmentBatteryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        android.util.Log.d("BatteryFragment", "onViewCreated called")

        setupObservers()
        setupClickListeners()
        // loadBannerAd()
        // loadBatteryInfo()
    }

    private fun loadBannerAd() {
        val adView = adManager.createBannerAd()
        binding.bannerAdContainer.addView(adView)
    }

    private fun setupObservers() {
        viewModel.batteryLevel.observe(viewLifecycleOwner) { level ->
            binding.batteryProgress.setProgress(level, false)
            binding.batteryLevelText.text = "$level%"
        }

        viewModel.batteryHealth.observe(viewLifecycleOwner) { health ->
            binding.batteryHealthText.text = health
        }

        viewModel.screenTimeout.observe(viewLifecycleOwner) { timeout ->
            binding.screenTimeoutText.text = formatTimeout(timeout)
        }

        viewModel.isBatterySaverEnabled.observe(viewLifecycleOwner) { enabled ->
            binding.batterySaverSwitch.isChecked = enabled
        }

        viewModel.isAutoSyncEnabled.observe(viewLifecycleOwner) { enabled ->
            binding.autoSyncSwitch.isChecked = enabled
        }
    }

    private fun setupClickListeners() {
        binding.batterySaverSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setBatterySaverEnabled(isChecked)
        }

        binding.autoSyncSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setAutoSyncEnabled(isChecked)
        }

        binding.optimizeBatteryButton.setOnClickListener {
            performBatteryOptimization()
        }

        binding.screenTimeoutButton.setOnClickListener {
            openScreenTimeoutSettings()
        }

        binding.backgroundAppsButton.setOnClickListener {
            openBackgroundAppsSettings()
        }
    }

    private fun loadBatteryInfo() {
        viewModel.loadBatteryInfo()
        viewModel.loadSystemSettings()
    }

    private fun performBatteryOptimization() {
        // Enable battery saver
        viewModel.setBatterySaverEnabled(true)

        // Disable auto-sync
        viewModel.setAutoSyncEnabled(false)

        // Set optimal screen timeout
        viewModel.setScreenTimeout(30000) // 30 seconds

        // Show success message
        binding.optimizationResult.visibility = View.VISIBLE
        binding.optimizationResult.text = "Battery optimization applied successfully!"
    }

    private fun openScreenTimeoutSettings() {
        try {
            val intent = Intent(Settings.ACTION_DISPLAY_SETTINGS)
            startActivity(intent)
        } catch (e: Exception) {
            // Fallback to general settings
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent)
        }
    }

    private fun openBackgroundAppsSettings() {
        try {
            val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
            startActivity(intent)
        } catch (e: Exception) {
            // Fallback to general settings
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent)
        }
    }

    private fun formatTimeout(timeout: Int): String {
        return when {
            timeout < 1000 -> "Immediately"
            timeout < 60000 -> "${timeout / 1000} seconds"
            timeout < 3600000 -> "${timeout / 60000} minutes"
            else -> "${timeout / 3600000} hours"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}