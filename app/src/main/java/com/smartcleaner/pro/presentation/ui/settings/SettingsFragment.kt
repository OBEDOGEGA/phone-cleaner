package com.smartcleaner.pro.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.smartcleaner.pro.R
import com.smartcleaner.pro.data.remote.AdManager
import com.smartcleaner.pro.databinding.FragmentSettingsBinding
import com.smartcleaner.pro.presentation.viewmodel.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SettingsViewModel by viewModels()

    @Inject
    lateinit var adManager: AdManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSettings()
        loadNativeAd()
    }

    private fun setupSettings() {
        setupScheduledCleaning()
    }

    private fun setupScheduledCleaning() {
        // Auto clean interval spinner
        val intervals = arrayOf("Disabled", "6 hours", "12 hours", "1 day", "3 days", "1 week")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, intervals)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.autoCleanIntervalSpinner.adapter = adapter

        // Set current selection (you'd load this from preferences)
        binding.autoCleanIntervalSpinner.setSelection(0) // Default to disabled

        binding.autoCleanIntervalSpinner.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> viewModel.cancelAutoClean() // Disabled
                    1 -> viewModel.scheduleAutoClean(6) // 6 hours
                    2 -> viewModel.scheduleAutoClean(12) // 12 hours
                    3 -> viewModel.scheduleAutoClean(24) // 1 day
                    4 -> viewModel.scheduleAutoClean(72) // 3 days
                    5 -> viewModel.scheduleAutoClean(168) // 1 week
                }
            }
            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
        }
    }

    private fun loadNativeAd() {
        val nativeAd = adManager.getNativeAd()
        if (nativeAd != null) {
            adManager.populateNativeAdView(binding.nativeAdView, nativeAd)
            binding.nativeAdView.visibility = View.VISIBLE
        } else {
            binding.nativeAdView.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}