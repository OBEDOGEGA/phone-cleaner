package com.smartphonecleaner.pro.presentation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.smartphonecleaner.pro.R
import com.smartphonecleaner.pro.data.remote.AdManager
import com.smartphonecleaner.pro.databinding.FragmentDashboardBinding
import com.smartphonecleaner.pro.presentation.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DashboardViewModel by viewModels()

    @Inject
    lateinit var adManager: AdManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupClickListeners()
        loadBannerAd()
    }

    private fun loadBannerAd() {
        val adView = adManager.createBannerAd()
        binding.bannerAdContainer.addView(adView)
    }

    private fun setupObservers() {
        android.util.Log.d("DashboardFragment", "Setting up observers")
        viewModel.batteryLevel.observe(viewLifecycleOwner) { level ->
            binding.batteryProgress.setProgress(level, false)
            binding.batteryText.text = "$level%"
            android.util.Log.d("DashboardFragment", "Battery level updated: $level%")
        }

        viewModel.storageUsed.observe(viewLifecycleOwner) { used ->
            val total = viewModel.totalStorage.value ?: 1L
            val percentage = (used.toFloat() / total * 100).toInt()
            binding.storageProgress.setProgress(percentage, false)
            binding.storageText.text = "$percentage%"
            android.util.Log.d("DashboardFragment", "Storage percentage: $percentage% (used: $used, total: $total)")
        }

        viewModel.todaySavings.observe(viewLifecycleOwner) { savings ->
            binding.todaySavingsValue.text = savings
            android.util.Log.d("DashboardFragment", "Today savings updated: $savings")
        }

        viewModel.weeklyPerformance.observe(viewLifecycleOwner) { performance ->
            binding.weeklyPerformanceValue.text = performance
            android.util.Log.d("DashboardFragment", "Weekly performance updated: $performance")
        }

        viewModel.batteryHealth.observe(viewLifecycleOwner) { health ->
            binding.batteryHealthValue.text = health
            android.util.Log.d("DashboardFragment", "Battery health updated: $health")
        }
    }

    private fun setupClickListeners() {
        binding.oneTapBoost.setOnClickListener {
            android.util.Log.d("DashboardFragment", "One tap boost clicked")
            try {
                findNavController().navigate(R.id.action_dashboardFragment_to_boostFragment)
                android.util.Log.d("DashboardFragment", "Navigation to boostFragment successful")
            } catch (e: Exception) {
                android.util.Log.e("DashboardFragment", "Navigation to boostFragment failed", e)
            }
        }

        binding.cleanNow.setOnClickListener {
            android.util.Log.d("DashboardFragment", "Clean now clicked")
            try {
                findNavController().navigate(R.id.action_dashboardFragment_to_scanFragment)
                android.util.Log.d("DashboardFragment", "Navigation to scanFragment successful")
            } catch (e: Exception) {
                android.util.Log.e("DashboardFragment", "Navigation to scanFragment failed", e)
            }
        }

        binding.batterySaver.setOnClickListener {
            android.util.Log.d("DashboardFragment", "Battery saver clicked")
            try {
                findNavController().navigate(R.id.action_dashboardFragment_to_batteryFragment)
                android.util.Log.d("DashboardFragment", "Navigation to batteryFragment successful")
            } catch (e: Exception) {
                android.util.Log.e("DashboardFragment", "Navigation to batteryFragment failed", e)
            }
        }

        binding.appManager.setOnClickListener {
            android.util.Log.d("DashboardFragment", "App manager clicked")
            try {
                findNavController().navigate(R.id.action_dashboardFragment_to_appListFragment)
                android.util.Log.d("DashboardFragment", "Navigation to appListFragment successful")
            } catch (e: Exception) {
                android.util.Log.e("DashboardFragment", "Navigation to appListFragment failed", e)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}