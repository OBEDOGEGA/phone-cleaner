package com.smartcleaner.pro.presentation.ui.cleaner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.smartcleaner.pro.data.remote.AdManager
import com.smartcleaner.pro.databinding.FragmentSummaryBinding
import com.smartcleaner.pro.domain.model.JunkItem
import com.smartcleaner.pro.presentation.viewmodel.CleanerViewModel
import com.smartcleaner.pro.utils.FeatureUnlockHelper
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat
import javax.inject.Inject

@AndroidEntryPoint
class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CleanerViewModel by viewModels()

    @Inject
    lateinit var adManager: AdManager

    @Inject
    lateinit var featureUnlockHelper: FeatureUnlockHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupClickListeners()
        displayResults()
        playConfettiAnimation()
    }

    private fun setupObservers() {
        viewModel.spaceSaved.observe(viewLifecycleOwner) { spaceSaved ->
            binding.spaceSavedText.text = "Space Saved: ${formatFileSize(spaceSaved)}"
        }

        viewModel.cleanTime.observe(viewLifecycleOwner) { time ->
            val seconds = time / 1000.0
            binding.timeTakenText.text = "Time Taken: ${DecimalFormat("#.##").format(seconds)} seconds"
        }

        viewModel.filesCleaned.observe(viewLifecycleOwner) { filesCleaned ->
            binding.filesCleanedText.text = "Files Cleaned: $filesCleaned"
        }
    }

    private fun setupClickListeners() {
        binding.watchAdButton.setOnClickListener {
            featureUnlockHelper.requestDeepCleanUnlock(requireActivity())
        }

        binding.doneButton.setOnClickListener {
            // Show rewarded ad for deep clean unlock
            showRewardedAdForDeepClean()
        }
    }

    private fun showRewardedAdForDeepClean() {
        featureUnlockHelper.requestFeatureUnlockViaRewardedAd("deep_clean", requireActivity()) {
            // Ad closed, navigate regardless
            navigateToDashboard()
        }
    }

    private fun navigateToDashboard() {
        findNavController().popBackStack(findNavController().graph.startDestinationId, false)
    }

    private fun displayResults() {
        val spaceSaved = viewModel.spaceSaved.value ?: 0L
        val timeTaken = viewModel.cleanTime.value ?: 0L
        val filesCleaned = viewModel.filesCleaned.value ?: 0

        binding.spaceSavedText.text = "Space Saved: ${formatFileSize(spaceSaved)}"
        binding.timeTakenText.text = "Time Taken: ${DecimalFormat("#.##").format(timeTaken / 1000.0)} seconds"
        binding.filesCleanedText.text = "Files Cleaned: $filesCleaned"

        // Trigger interstitial ad if saved size > 50MB
        adManager.tryShowInterstitialAfterClean(requireActivity(), spaceSaved)
    }

    private fun playConfettiAnimation() {
        binding.confettiAnimation.playAnimation()
    }

    private fun formatFileSize(size: Long): String {
        if (size <= 0) return "0 B"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt()
        return DecimalFormat("#,##0.#").format(size / Math.pow(1024.0, digitGroups.toDouble())) + " " + units[digitGroups]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}