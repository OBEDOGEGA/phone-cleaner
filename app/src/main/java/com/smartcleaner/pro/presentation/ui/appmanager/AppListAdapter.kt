package com.smartcleaner.pro.presentation.ui.appmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartcleaner.pro.databinding.ItemAppBinding
import com.smartcleaner.pro.domain.model.AppInfo
import java.text.SimpleDateFormat
import java.util.*

class AppListAdapter(
    private val onAppClick: (AppInfo) -> Unit,
    private val onAppSelectionChanged: (String, Boolean) -> Unit
) : ListAdapter<AppInfo, AppListAdapter.AppViewHolder>(AppDiffCallback()) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val binding = ItemAppBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bind(getItem(position))
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

    class AppDiffCallback : DiffUtil.ItemCallback<AppInfo>() {
        override fun areItemsTheSame(oldItem: AppInfo, newItem: AppInfo): Boolean {
            return oldItem.packageName == newItem.packageName
        }

        override fun areContentsTheSame(oldItem: AppInfo, newItem: AppInfo): Boolean {
            return oldItem == newItem
        }
    }
}