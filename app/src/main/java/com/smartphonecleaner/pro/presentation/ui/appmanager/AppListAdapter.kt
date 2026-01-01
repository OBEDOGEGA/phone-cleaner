package com.smartphonecleaner.pro.presentation.ui.appmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.nativead.NativeAd
import com.smartphonecleaner.pro.data.remote.AdManager
import com.smartphonecleaner.pro.databinding.ItemAppBinding
import com.smartphonecleaner.pro.databinding.NativeAdLayoutBinding
import com.smartphonecleaner.pro.domain.model.AppInfo
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AppListAdapter @Inject constructor(
    private val adManager: AdManager,
    private val onAppClick: (AppInfo) -> Unit,
    private val onAppSelectionChanged: (String, Boolean) -> Unit
) : ListAdapter<AppListItem, RecyclerView.ViewHolder>(AppListItemDiffCallback()) {

    companion object {
        private const val VIEW_TYPE_APP_ITEM = 0
        private const val VIEW_TYPE_AD = 1
    }

    private val selectedApps = mutableSetOf<String>()
    private var selectionMode = false

    fun setSelectionMode(enabled: Boolean) {
        selectionMode = enabled
        notifyDataSetChanged()
    }

    fun setSelectedApps(selected: Set<String>) {
        selectedApps.clear()
        selectedApps.addAll(selected)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is AppListItem.AppItem -> VIEW_TYPE_APP_ITEM
            is AppListItem.AdItem -> VIEW_TYPE_AD
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_APP_ITEM -> {
                val binding = ItemAppBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                AppViewHolder(binding)
            }
            VIEW_TYPE_AD -> {
                val binding = NativeAdLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                AdViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is AppListItem.AppItem -> (holder as AppViewHolder).bind(item.appInfo)
            is AppListItem.AdItem -> (holder as AdViewHolder).bind(item.nativeAd)
        }
    }

    inner class AppViewHolder(private val binding: ItemAppBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(appInfo: AppInfo) {
            binding.appName.text = appInfo.appName
            binding.packageName.text = appInfo.packageName
            binding.appIcon.setImageDrawable(appInfo.icon)
            binding.appSize.text = formatSize(appInfo.size)
            binding.appType.text = if (appInfo.isSystemApp) "SYSTEM" else "USER"

            // Handle selection mode
            binding.appCheckbox.visibility = if (selectionMode) android.view.View.VISIBLE else android.view.View.GONE
            binding.appCheckbox.isChecked = selectedApps.contains(appInfo.packageName)

            // Click listeners
            binding.root.setOnClickListener {
                if (selectionMode) {
                    binding.appCheckbox.isChecked = !binding.appCheckbox.isChecked
                    onAppSelectionChanged(appInfo.packageName, binding.appCheckbox.isChecked)
                } else {
                    onAppClick(appInfo)
                }
            }

            binding.appCheckbox.setOnCheckedChangeListener { _, isChecked ->
                onAppSelectionChanged(appInfo.packageName, isChecked)
            }
        }

        private fun formatSize(bytes: Long): String {
            val units = arrayOf("B", "KB", "MB", "GB")
            var size = bytes.toDouble()
            var unitIndex = 0

            while (size >= 1024 && unitIndex < units.size - 1) {
                size /= 1024
                unitIndex++
            }

            return "%.1f %s".format(size, units[unitIndex])
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

    class AppListItemDiffCallback : DiffUtil.ItemCallback<AppListItem>() {
        override fun areItemsTheSame(oldItem: AppListItem, newItem: AppListItem): Boolean {
            return when {
                oldItem is AppListItem.AppItem && newItem is AppListItem.AppItem ->
                    oldItem.appInfo.packageName == newItem.appInfo.packageName
                oldItem is AppListItem.AdItem && newItem is AppListItem.AdItem -> true
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: AppListItem, newItem: AppListItem): Boolean {
            return oldItem == newItem
        }
    }
}