package com.smartcleaner.pro.presentation.ui.tools

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartcleaner.pro.databinding.FragmentLargeFilesBinding
import com.smartcleaner.pro.presentation.common.BaseFragment
import com.smartcleaner.pro.presentation.viewmodel.ToolsViewModel
import com.smartcleaner.pro.data.remote.AdManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LargeFilesFragment : BaseFragment() {

    companion object {
        private const val TAG = "LargeFilesFragment"
    }

    private var _binding: FragmentLargeFilesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ToolsViewModel by viewModels()
    private lateinit var largeFileAdapter: LargeFileAdapter

    @Inject
    lateinit var adManager: AdManager

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        Log.d(TAG, "Permission result: isGranted = $isGranted")
        if (isGranted) {
            startScanning()
        } else {
            // Show permission denied message
            Log.d(TAG, "Permission denied, showing permission message")
            binding.permissionMessage.visibility = View.VISIBLE
            binding.scanButton.visibility = View.GONE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLargeFilesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated called")

        setupRecyclerView()
        setupClickListeners()
        setupObservers()

        checkPermissionAndScan()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
        // Check permission again in case user granted it in settings
        checkPermissionAndScan()
    }

    private fun checkPermissionAndScan() {
        val hasPermission = hasStoragePermission()
        Log.d(TAG, "Storage permission status: $hasPermission")

        if (hasPermission) {
            startScanning()
        } else {
            // Show permission message
            binding.permissionMessage.visibility = View.VISIBLE
            binding.scanButton.visibility = View.GONE
        }
    }

    private fun setupRecyclerView() {
        largeFileAdapter = LargeFileAdapter()
        binding.largeFilesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = largeFileAdapter
        }
    }

    private fun setupClickListeners() {
        binding.scanButton.setOnClickListener {
            Log.d(TAG, "Scan button clicked")
            if (hasStoragePermission()) {
                startScanning()
            } else {
                requestStoragePermission()
            }
        }

        binding.grantPermissionButton.setOnClickListener {
            Log.d(TAG, "Grant permission button clicked")
            requestStoragePermission()
        }
    }

    private fun setupObservers() {
        viewModel.largeFiles.observe(viewLifecycleOwner) { largeFiles ->
            binding.progressBar.visibility = View.GONE
            binding.scanButton.visibility = View.VISIBLE

            if (largeFiles.isNotEmpty()) {
                largeFileAdapter.submitList(largeFiles)
                binding.largeFilesRecyclerView.visibility = View.VISIBLE
                binding.emptyState.visibility = View.GONE
                binding.permissionMessage.visibility = View.GONE
            } else {
                binding.largeFilesRecyclerView.visibility = View.GONE
                binding.emptyState.visibility = View.VISIBLE
                binding.permissionMessage.visibility = View.GONE
                showNativeAdInEmptyState()
            }
        }

        viewModel.isScanningLargeFiles.observe(viewLifecycleOwner) { isScanning ->
            if (isScanning) {
                binding.progressBar.visibility = View.VISIBLE
                binding.scanButton.visibility = View.GONE
                binding.scanningText.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.scanButton.visibility = View.VISIBLE
                binding.scanningText.visibility = View.GONE
            }
        }
    }

    private fun hasStoragePermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // For Android 11+, we need MANAGE_EXTERNAL_STORAGE for full file access
            android.os.Environment.isExternalStorageManager()
        } else {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun requestStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // For Android 11+, request MANAGE_EXTERNAL_STORAGE via settings
            Log.d(TAG, "Requesting MANAGE_EXTERNAL_STORAGE via settings")
            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION).apply {
                data = Uri.parse("package:${requireContext().packageName}")
            }
            startActivity(intent)
        } else {
            // For older versions, request READ_EXTERNAL_STORAGE
            Log.d(TAG, "Launching permission request for READ_EXTERNAL_STORAGE")
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private fun startScanning() {
        binding.permissionMessage.visibility = View.GONE
        viewModel.scanForLargeFiles()
    }

    private fun showNativeAdInEmptyState() {
        val nativeAd = adManager.getNativeAd()
        if (nativeAd != null) {
            val adView = binding.emptyStateNativeAd.root
            adManager.populateNativeAdView(adView, nativeAd)
            adView.visibility = View.VISIBLE
        } else {
            binding.emptyStateNativeAd.root.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}