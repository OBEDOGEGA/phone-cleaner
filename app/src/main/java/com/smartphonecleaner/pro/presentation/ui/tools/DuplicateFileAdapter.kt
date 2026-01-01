package com.smartphonecleaner.pro.presentation.ui.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartphonecleaner.pro.databinding.ItemDuplicateFileBinding
import com.smartphonecleaner.pro.domain.model.DuplicateFile
import java.text.SimpleDateFormat
import java.util.*

class DuplicateFileAdapter : ListAdapter<DuplicateFile, DuplicateFileAdapter.DuplicateFileViewHolder>(DuplicateFileDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DuplicateFileViewHolder {
        val binding = ItemDuplicateFileBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DuplicateFileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DuplicateFileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DuplicateFileViewHolder(
        private val binding: ItemDuplicateFileBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(duplicateFile: DuplicateFile) {
            binding.fileName.text = duplicateFile.file.name
            binding.filePath.text = duplicateFile.file.parent ?: ""
            binding.fileSize.text = formatFileSize(duplicateFile.size)
            binding.duplicateCount.text = "${duplicateFile.duplicateGroup.size} duplicates"

            binding.checkbox.isChecked = duplicateFile.isSelected
            binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
                duplicateFile.isSelected = isChecked
            }
        }

        private fun formatFileSize(size: Long): String {
            val units = arrayOf("B", "KB", "MB", "GB")
            var fileSize = size.toDouble()
            var unitIndex = 0

            while (fileSize >= 1024 && unitIndex < units.size - 1) {
                fileSize /= 1024
                unitIndex++
            }

            return "%.1f %s".format(fileSize, units[unitIndex])
        }
    }
}

class DuplicateFileDiffCallback : DiffUtil.ItemCallback<DuplicateFile>() {
    override fun areItemsTheSame(oldItem: DuplicateFile, newItem: DuplicateFile): Boolean {
        return oldItem.file.absolutePath == newItem.file.absolutePath
    }

    override fun areContentsTheSame(oldItem: DuplicateFile, newItem: DuplicateFile): Boolean {
        return oldItem == newItem
    }
}