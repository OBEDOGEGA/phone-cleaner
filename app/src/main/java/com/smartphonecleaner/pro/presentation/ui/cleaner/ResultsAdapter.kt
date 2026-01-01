package com.smartphonecleaner.pro.presentation.ui.cleaner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.nativead.NativeAd
import com.smartphonecleaner.pro.R
import com.smartphonecleaner.pro.data.remote.AdManager
import com.smartphonecleaner.pro.databinding.ItemJunkFileBinding
import com.smartphonecleaner.pro.databinding.NativeAdLayoutBinding
import com.smartphonecleaner.pro.domain.model.JunkItem
import java.text.DecimalFormat
import javax.inject.Inject

class ResultsAdapter @Inject constructor(
    private val adManager: AdManager,
    private val onItemChecked: (JunkItem, Boolean) -> Unit
) : ListAdapter<ResultsListItem, RecyclerView.ViewHolder>(ResultsListItemDiffCallback()) {

    companion object {
        private const val VIEW_TYPE_JUNK_ITEM = 0
        private const val VIEW_TYPE_AD = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ResultsListItem.JunkItemWrapper -> VIEW_TYPE_JUNK_ITEM
            is ResultsListItem.AdItem -> VIEW_TYPE_AD
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_JUNK_ITEM -> {
                val binding = ItemJunkFileBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                JunkItemViewHolder(binding)
            }
            VIEW_TYPE_AD -> {
                val binding = NativeAdLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                AdViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is ResultsListItem.JunkItemWrapper -> (holder as JunkItemViewHolder).bind(item.junkItem)
            is ResultsListItem.AdItem -> (holder as AdViewHolder).bind(item.nativeAd)
        }
    }

    inner class JunkItemViewHolder(
        private val binding: ItemJunkFileBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: JunkItem) {
            binding.fileNameText.text = item.file.name
            binding.filePathText.text = item.file.parent ?: ""
            binding.fileSizeText.text = formatFileSize(item.size)
            binding.categoryText.text = item.category
            binding.checkBox.isChecked = item.isSelected

            binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
                onItemChecked(item, isChecked)
            }

            binding.root.setOnClickListener {
                binding.checkBox.isChecked = !binding.checkBox.isChecked
            }
        }

        private fun formatFileSize(size: Long): String {
            if (size <= 0) return "0 B"
            val units = arrayOf("B", "KB", "MB", "GB", "TB")
            val digitGroups = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt()
            return DecimalFormat("#,##0.#").format(size / Math.pow(1024.0, digitGroups.toDouble())) + " " + units[digitGroups]
        }
    }

    inner class AdViewHolder(
        private val binding: NativeAdLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(nativeAd: NativeAd?) {
            if (nativeAd != null) {
                adManager.populateNativeAdView(binding.nativeAdView, nativeAd)
                binding.nativeAdView.visibility = android.view.View.VISIBLE
            } else {
                binding.nativeAdView.visibility = android.view.View.GONE
            }
        }
    }

    class ResultsListItemDiffCallback : DiffUtil.ItemCallback<ResultsListItem>() {
        override fun areItemsTheSame(oldItem: ResultsListItem, newItem: ResultsListItem): Boolean {
            return when {
                oldItem is ResultsListItem.JunkItemWrapper && newItem is ResultsListItem.JunkItemWrapper ->
                    oldItem.junkItem.file.absolutePath == newItem.junkItem.file.absolutePath
                oldItem is ResultsListItem.AdItem && newItem is ResultsListItem.AdItem -> true
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: ResultsListItem, newItem: ResultsListItem): Boolean {
            return oldItem == newItem
        }
    }
}