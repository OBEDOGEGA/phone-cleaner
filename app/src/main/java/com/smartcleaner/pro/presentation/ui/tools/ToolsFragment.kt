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
import com.smartcleaner.pro.data.remote.AdManager
import com.smartcleaner.pro.databinding.FragmentToolsBinding
import com.smartcleaner.pro.presentation.ui.tools.ToolItem
import com.smartcleaner.pro.presentation.common.BaseFragment
import com.smartcleaner.pro.presentation.viewmodel.ToolsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ToolsFragment : BaseFragment() {

    @Inject
    lateinit var adManager: AdManager

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
        toolsAdapter = ToolsAdapter(adManager) { tool ->
            when (tool.id) {
                "duplicate_finder" -> navigateToDuplicateFinder()
                "large_files" -> navigateToLargeFiles()
            }
        }

        binding.toolsRecyclerView.apply {
            val gridLayoutManager = GridLayoutManager(requireContext(), 2)
            gridLayoutManager.spanSizeLookup = object : androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return toolsAdapter.getSpanSize(position)
                }
            }
            layoutManager = gridLayoutManager
            adapter = toolsAdapter
        }

        // Set up tools data with ad at position 2 (3rd item)
        val toolItems = listOf(
            ToolItem.Tool(Tool("duplicate_finder", "Duplicate Files", "Find and remove duplicate files", R.drawable.ic_duplicate)),
            ToolItem.Tool(Tool("large_files", "Large Files", "Find and manage large files", R.drawable.ic_large_file)),
            ToolItem.Ad
        )
        toolsAdapter.submitList(toolItems)
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