package com.smartcleaner.pro.presentation.ui.appmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.smartcleaner.pro.R
import com.smartcleaner.pro.databinding.FragmentAppListBinding
import com.smartcleaner.pro.presentation.common.BaseFragment
import com.smartcleaner.pro.presentation.viewmodel.AppManagerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AppListFragment : BaseFragment() {

    private var _binding: FragmentAppListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AppManagerViewModel by viewModels()
    private lateinit var adapter: AppListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAppListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupSpinners()
        setupBatchOperations()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = AppListAdapter(
            onAppClick = { appInfo ->
                // Navigate to app detail
                val action = AppListFragmentDirections.actionAppListFragmentToAppDetailFragment(
                    packageName = appInfo.packageName
                )
                findNavController().navigate(action)
            },
            onAppSelectionChanged = { packageName, isSelected ->
                viewModel.toggleAppSelection(packageName)
            }
        )

        binding.appsRecyclerView.adapter = adapter
    }

    private fun setupSpinners() {
        // Sort spinner
        val sortAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.sort_options,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.sortSpinner.adapter = sortAdapter

        binding.sortSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val sortBy = when (position) {
                    0 -> AppManagerViewModel.SortBy.NAME
                    1 -> AppManagerViewModel.SortBy.SIZE
                    2 -> AppManagerViewModel.SortBy.LAST_USED
                    else -> AppManagerViewModel.SortBy.NAME
                }
                viewModel.setSortBy(sortBy)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Filter spinner
        val filterAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.filter_options,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.filterSpinner.adapter = filterAdapter

        binding.filterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val filterBy = when (position) {
                    0 -> AppManagerViewModel.FilterBy.ALL
                    1 -> AppManagerViewModel.FilterBy.USER
                    2 -> AppManagerViewModel.FilterBy.SYSTEM
                    else -> AppManagerViewModel.FilterBy.ALL
                }
                viewModel.setFilterBy(filterBy)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupBatchOperations() {
        binding.selectAllBtn.setOnClickListener {
            viewModel.selectAllApps()
        }

        binding.clearSelectionBtn.setOnClickListener {
            viewModel.clearSelection()
        }

        binding.uninstallSelectedBtn.setOnClickListener {
            viewModel.uninstallSelectedApps()
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.filteredApps.collect { apps ->
                adapter.submitList(apps)
                binding.emptyText.visibility = if (apps.isEmpty()) View.VISIBLE else View.GONE
            }
        }

        viewModel.selectedApps.observe(viewLifecycleOwner) { selected ->
            adapter.setSelectedApps(selected)
            binding.batchLayout.visibility = if (selected.isNotEmpty()) View.VISIBLE else View.GONE
            adapter.setSelectionMode(selected.isNotEmpty())
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.loadingProgress.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.appsRecyclerView.visibility = if (isLoading) View.GONE else View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}