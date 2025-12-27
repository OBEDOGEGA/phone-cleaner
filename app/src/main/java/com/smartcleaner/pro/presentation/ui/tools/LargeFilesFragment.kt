package com.smartcleaner.pro.presentation.ui.tools

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
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

    private var _binding: FragmentLargeFilesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ToolsViewModel by viewModels()
    private lateinit var largeFileAdapter: LargeFileAdapter

    @Inject
    lateinit var adManager: AdManager

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            startScanning()
        } else {
            // Show permission denied message
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

        setupRecyclerView()
        setupClickListeners()
        setupObservers()

        if (hasStoragePermission()) {
            startScanning()
        } else {
            requestStoragePermission()
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
            if (hasStoragePermission()) {
                startScanning()
            } else {
                requestStoragePermission()
            }
        }

        binding.grantPermissionButton.setOnClickListener {
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
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestStoragePermission() {
        requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
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