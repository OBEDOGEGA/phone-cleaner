package com.smartcleaner.pro.presentation.ui.appmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartcleaner.pro.databinding.ItemPermissionBinding

class PermissionsAdapter : ListAdapter<String, PermissionsAdapter.PermissionViewHolder>(PermissionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PermissionViewHolder {
        val binding = ItemPermissionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PermissionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PermissionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PermissionViewHolder(private val binding: ItemPermissionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(permission: String) {
            binding.root.text = permission
        }
    }

    class PermissionDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}