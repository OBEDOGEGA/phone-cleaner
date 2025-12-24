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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.smartcleaner.pro.R
import com.smartcleaner.pro.databinding.FragmentToolsBinding
import com.smartcleaner.pro.presentation.common.BaseFragment
import com.smartcleaner.pro.presentation.viewmodel.ToolsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToolsFragment : BaseFragment() {

    private var _binding: FragmentToolsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ToolsViewModel by viewModels()
    private lateinit var toolsAdapter: ToolsAdapter

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted, can proceed with file operations
        } else {
            // Permission denied, show message
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToolsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        checkPermissions()
    }

    private fun setupRecyclerView() {
        toolsAdapter = ToolsAdapter { tool ->
            when (tool.id) {
                "duplicate_finder" -> navigateToDuplicateFinder()
                "large_files" -> navigateToLargeFiles()
            }
        }

        binding.toolsRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = toolsAdapter
        }

        // Set up tools data
        val tools = listOf(
            Tool("duplicate_finder", "Duplicate Files", "Find and remove duplicate files", R.drawable.ic_duplicate),
            Tool("large_files", "Large Files", "Find and manage large files", R.drawable.ic_large_file)
        )
        toolsAdapter.submitList(tools)
    }

    private fun checkPermissions() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Permission already granted
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

    private fun navigateToDuplicateFinder() {
        findNavController().navigate(R.id.action_toolsFragment_to_duplicateFinderFragment)
    }

    private fun navigateToLargeFiles() {
        findNavController().navigate(R.id.action_toolsFragment_to_largeFilesFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}