package com.smartcleaner.pro.presentation.ui.cleaner

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.smartcleaner.pro.R
import com.smartcleaner.pro.databinding.FragmentScanBinding
import com.smartcleaner.pro.presentation.viewmodel.CleanerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScanFragment : Fragment() {

    private var _binding: FragmentScanBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CleanerViewModel by viewModels()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val allGranted = permissions.values.all { it }
        if (allGranted) {
            startScanning()
        } else {
            // Handle permission denied
            findNavController().navigateUp()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupClickListeners()
        checkPermissionsAndStartScan()
    }

    private fun setupObservers() {
        viewModel.scanProgress.observe(viewLifecycleOwner) { progress ->
            binding.scanProgressBar.progress = progress
            binding.progressText.text = "Scanning... $progress%"

            // Update scanning status based on progress
            binding.scanningStatus.text = when {
                progress < 20 -> "Checking cache files..."
                progress < 40 -> "Scanning residual files..."
                progress < 60 -> "Looking for APK files..."
                progress < 80 -> "Checking empty folders..."
                progress < 100 -> "Scanning thumbnail cache..."
                else -> "Scan complete!"
            }

            if (progress >= 100) {
                navigateToResults()
            }
        }

        viewModel.isScanning.observe(viewLifecycleOwner) { isScanning ->
            binding.stopScanButton.isEnabled = isScanning
        }
    }

    private fun setupClickListeners() {
        binding.stopScanButton.setOnClickListener {
            viewModel.stopScanning()
            findNavController().navigateUp()
        }
    }

    private fun checkPermissionsAndStartScan() {
        val permissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        val allGranted = permissions.all { permission ->
            ContextCompat.checkSelfPermission(requireContext(), permission) == PackageManager.PERMISSION_GRANTED
        }

        if (allGranted) {
            startScanning()
        } else {
            requestPermissionLauncher.launch(permissions)
        }
    }

    private fun startScanning() {
        viewModel.startScanning()
    }

    private fun navigateToResults() {
        findNavController().navigate(R.id.action_scanFragment_to_resultsFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.stopScanning()
        _binding = null
    }
}