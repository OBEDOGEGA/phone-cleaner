package com.smartphonecleaner.pro.presentation.ui.tools

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import com.smartphonecleaner.pro.R
import com.smartphonecleaner.pro.data.remote.AdManager
import com.smartphonecleaner.pro.databinding.ItemToolBinding
import com.smartphonecleaner.pro.databinding.NativeAdLayoutBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

data class ToolModel(
    val id: String,
    val title: String,
    val description: String,
    val iconResId: Int
)

sealed class ToolItem {
    data class Tool(val tool: ToolModel) : ToolItem()
    object Ad : ToolItem()
}

class ToolsAdapter(
    private val adManager: AdManager,
    private val onToolClick: (ToolModel) -> Unit
) : ListAdapter<ToolItem, RecyclerView.ViewHolder>(ToolItemDiffCallback()) {

    companion object {
        private const val VIEW_TYPE_TOOL = 0
        private const val VIEW_TYPE_AD = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ToolItem.Tool -> VIEW_TYPE_TOOL
            is ToolItem.Ad -> VIEW_TYPE_AD
        }
    }

    // Add this method to handle span size
    fun getSpanSize(position: Int): Int {
        return when (getItem(position)) {
            is ToolItem.Tool -> 1
            is ToolItem.Ad -> 2 // Ad spans both columns
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_TOOL -> {
                val binding = ItemToolBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ToolViewHolder(binding)
            }
            VIEW_TYPE_AD -> {
                val binding = NativeAdLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                AdViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is ToolItem.Tool -> (holder as ToolViewHolder).bind(item.tool)
            is ToolItem.Ad -> (holder as AdViewHolder).bind()
        }
    }

    class ToolItemDiffCallback : DiffUtil.ItemCallback<ToolItem>() {
        override fun areItemsTheSame(oldItem: ToolItem, newItem: ToolItem): Boolean {
            return when {
                oldItem is ToolItem.Tool && newItem is ToolItem.Tool -> oldItem.tool.id == newItem.tool.id
                oldItem is ToolItem.Ad && newItem is ToolItem.Ad -> true
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: ToolItem, newItem: ToolItem): Boolean {
            return oldItem == newItem
        }
    }

    inner class ToolViewHolder(
        private val binding: ItemToolBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item is ToolItem.Tool) {
                        onToolClick(item.tool)
                    }
                }
            }
        }

        fun bind(tool: ToolModel) {
            binding.toolIcon.setImageResource(tool.iconResId)
            binding.toolTitle.text = tool.title
            binding.toolDescription.text = tool.description
        }
    }

    inner class AdViewHolder(
        private val binding: NativeAdLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            Log.d("ToolsAdapter", "Binding ad view holder")
            val nativeAd = adManager.getNativeAd()
            if (nativeAd != null) {
                Log.d("ToolsAdapter", "Native ad available, populating view")
                adManager.populateNativeAdView(binding.nativeAdView, nativeAd)
                binding.nativeAdView.visibility = View.VISIBLE
            } else {
                Log.d("ToolsAdapter", "Native ad not available")
                binding.nativeAdView.visibility = View.GONE
            }
        }
    }
}

class ToolDiffCallback : DiffUtil.ItemCallback<ToolModel>() {
    override fun areItemsTheSame(oldItem: ToolModel, newItem: ToolModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ToolModel, newItem: ToolModel): Boolean {
        return oldItem == newItem
    }
}