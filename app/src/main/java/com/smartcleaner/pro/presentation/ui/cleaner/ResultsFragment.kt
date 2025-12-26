package com.smartcleaner.pro.presentation.ui.cleaner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.nativead.NativeAd
import com.smartcleaner.pro.R
import com.smartcleaner.pro.data.remote.AdManager
import com.smartcleaner.pro.databinding.FragmentResultsBinding
import com.smartcleaner.pro.domain.model.JunkItem
import com.smartcleaner.pro.presentation.viewmodel.CleanerViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.DecimalFormat
import javax.inject.Inject

@AndroidEntryPoint
class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CleanerViewModel by viewModels()
    private lateinit var adapter: ResultsAdapter

    @Inject
    lateinit var adManager: AdManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        adapter = ResultsAdapter(adManager) { item, isSelected ->
            viewModel.updateJunkItemSelection(item, isSelected)
        }

        binding.resultsRecyclerView.adapter = adapter
        binding.resultsRecyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        )
    }

    private fun setupObservers() {
        viewModel.junkItems.observe(viewLifecycleOwner) { items ->
            val listWithAds = createListWithAds(items)
            adapter.submitList(listWithAds)
            updateTotalSize(items)
        }

        viewModel.totalJunkSize.observe(viewLifecycleOwner) { totalSize ->
            binding.totalSizeText.text = formatFileSize(totalSize)
        }
    }

    private fun createListWithAds(items: List<JunkItem>): List<ResultsListItem> {
        val groupedItems = items.groupBy { it.category }
        val result = mutableListOf<ResultsListItem>()

        groupedItems.forEach { (category, categoryItems) ->
            // Add all items in this category
            result.addAll(categoryItems.map { ResultsListItem.JunkItemWrapper(it) })
            // Add an ad after the category
            result.add(ResultsListItem.AdItem(adManager.getNativeAd()))
        }

        return result
    }

    private fun setupClickListeners() {
        binding.cleanButton.setOnClickListener {
            val selectedItems = viewModel.getSelectedItems()
            if (selectedItems.isNotEmpty()) {
                navigateToClean(selectedItems)
            }
        }

        binding.selectAllButton.setOnClickListener {
            val allItems = viewModel.junkItems.value ?: emptyList()
            val allSelected = allItems.all { it.isSelected }

            allItems.forEach { item ->
                viewModel.updateJunkItemSelection(item, !allSelected)
            }

            binding.selectAllButton.text = if (allSelected) "Select All" else "Deselect All"
        }
    }

    private fun updateTotalSize(items: List<JunkItem>) {
        val selectedSize = items.filter { it.isSelected }.sumOf { it.size }
        binding.totalSizeText.text = "Selected: ${formatFileSize(selectedSize)}"
    }

    private fun navigateToClean(selectedItems: List<JunkItem>) {
        val bundle = Bundle().apply {
            putParcelableArrayList("selectedItems", ArrayList(selectedItems))
        }
        findNavController().navigate(R.id.action_resultsFragment_to_cleanFragment, bundle)
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