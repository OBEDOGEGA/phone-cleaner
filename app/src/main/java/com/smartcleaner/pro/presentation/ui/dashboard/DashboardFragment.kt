package com.smartcleaner.pro.presentation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.smartcleaner.pro.R
import com.smartcleaner.pro.data.remote.AdManager
import com.smartcleaner.pro.databinding.FragmentDashboardBinding
import com.smartcleaner.pro.presentation.viewmodel.DashboardViewModel
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
        viewModel.batteryLevel.observe(viewLifecycleOwner) { level ->
            binding.batteryProgress.setProgress(level, false)
            binding.batteryText.text = "$level%"
        }

        viewModel.storageUsed.observe(viewLifecycleOwner) { used ->
            val percentage = (used.toFloat() / viewModel.totalStorage.value!! * 100).toInt()
            binding.storageProgress.setProgress(percentage, false)
            binding.storageText.text = "$percentage%"
        }

        viewModel.todaySavings.observe(viewLifecycleOwner) { savings ->
            binding.todaySavingsValue.text = savings
        }

        viewModel.weeklyPerformance.observe(viewLifecycleOwner) { performance ->
            binding.weeklyPerformanceValue.text = performance
        }

        viewModel.batteryHealth.observe(viewLifecycleOwner) { health ->
            binding.batteryHealthValue.text = health
        }
    }

    private fun setupClickListeners() {
        binding.oneTapBoost.setOnClickListener {
            // Placeholder: Navigate to boost screen
        }

        binding.cleanNow.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_scanFragment)
        }

        binding.batterySaver.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_batteryFragment)
        }

        binding.appManager.setOnClickListener {
            // Placeholder: Navigate to app manager
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}