package com.smartcleaner.pro.presentation.ui.boost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartcleaner.pro.databinding.ItemRunningAppBinding
import com.smartcleaner.pro.domain.model.RunningApp

class RunningAppAdapter(
    private val onWhitelistToggle: (String) -> Unit
) : ListAdapter<RunningApp, RunningAppAdapter.RunningAppViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunningAppViewHolder {
        val binding = ItemRunningAppBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RunningAppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RunningAppViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RunningAppViewHolder(private val binding: ItemRunningAppBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(runningApp: RunningApp) {
            binding.appNameTextView.text = runningApp.appName
            binding.memoryTextView.text = "${runningApp.memoryUsage / 1024} MB"
            binding.whitelistCheckBox.isChecked = runningApp.isWhitelisted
            binding.whitelistCheckBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked != runningApp.isWhitelisted) {
                    onWhitelistToggle(runningApp.packageName)
                }
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<RunningApp>() {
            override fun areItemsTheSame(oldItem: RunningApp, newItem: RunningApp): Boolean {
                return oldItem.packageName == newItem.packageName
            }

            override fun areContentsTheSame(oldItem: RunningApp, newItem: RunningApp): Boolean {
                return oldItem == newItem
            }
        }
    }
}