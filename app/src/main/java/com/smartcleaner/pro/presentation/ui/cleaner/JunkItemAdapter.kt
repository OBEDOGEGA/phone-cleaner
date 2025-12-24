package com.smartcleaner.pro.presentation.ui.cleaner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartcleaner.pro.databinding.ItemJunkFileBinding
import com.smartcleaner.pro.domain.model.JunkItem
import java.text.DecimalFormat

class JunkItemAdapter(
    private val onItemChecked: (JunkItem, Boolean) -> Unit
) : ListAdapter<JunkItem, JunkItemAdapter.JunkItemViewHolder>(JunkItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JunkItemViewHolder {
        val binding = ItemJunkFileBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return JunkItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JunkItemViewHolder, position: Int) {
        holder.bind(getItem(position))
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

    class JunkItemDiffCallback : DiffUtil.ItemCallback<JunkItem>() {
        override fun areItemsTheSame(oldItem: JunkItem, newItem: JunkItem): Boolean {
            return oldItem.file.absolutePath == newItem.file.absolutePath
        }

        override fun areContentsTheSame(oldItem: JunkItem, newItem: JunkItem): Boolean {
            return oldItem == newItem
        }
    }
}