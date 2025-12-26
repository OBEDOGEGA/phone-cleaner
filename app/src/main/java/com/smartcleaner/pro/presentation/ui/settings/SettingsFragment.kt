package com.smartcleaner.pro.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smartcleaner.pro.R
import com.smartcleaner.pro.data.remote.AdManager
import com.smartcleaner.pro.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

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
        // Add settings options here
        // For now, just placeholder
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