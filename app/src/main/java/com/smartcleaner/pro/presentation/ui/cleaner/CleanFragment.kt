package com.smartcleaner.pro.presentation.ui.cleaner

import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.smartcleaner.pro.R
import com.smartcleaner.pro.databinding.FragmentCleanBinding
import com.smartcleaner.pro.domain.model.JunkItem
import com.smartcleaner.pro.presentation.viewmodel.CleanerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CleanFragment : Fragment() {

    private var _binding: FragmentCleanBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CleanerViewModel by viewModels()
    private lateinit var selectedItems: List<JunkItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCleanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedItems = arguments?.getParcelableArrayList("selectedItems") ?: emptyList()

        setupObservers()
        setupClickListeners()
        startCleaning()
    }

    private fun setupObservers() {
        viewModel.cleanProgress.observe(viewLifecycleOwner) { progress ->
            binding.cleanProgressBar.progress = progress
            binding.progressText.text = "Cleaning... $progress%"

            // Update cleaning status based on progress
            binding.cleaningStatus.text = when {
                progress < 30 -> "Removing cache files..."
                progress < 60 -> "Deleting residual files..."
                progress < 90 -> "Cleaning APK files..."
                progress < 100 -> "Finalizing cleanup..."
                else -> "Cleanup complete!"
            }

            if (progress >= 100) {
                navigateToSummary()
            }
        }

        viewModel.isCleaning.observe(viewLifecycleOwner) { isCleaning ->
            binding.stopCleanButton.isEnabled = isCleaning
        }
    }

    private fun setupClickListeners() {
        binding.stopCleanButton.setOnClickListener {
            viewModel.stopCleaning()
            findNavController().navigateUp()
        }
    }

    private fun startCleaning() {
        if (selectedItems.isNotEmpty()) {
            performHapticFeedback()
            viewModel.startCleaning(selectedItems)
        } else {
            // No items to clean, go back
            findNavController().navigateUp()
        }
    }

    private fun performHapticFeedback() {
        val vibrator = requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(50)
    }

    private fun navigateToSummary() {
        findNavController().navigate(R.id.action_cleanFragment_to_summaryFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.stopCleaning()
        _binding = null
    }
}