package com.smartcleaner.pro.presentation.ui.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartcleaner.pro.databinding.ItemLargeFileBinding
import com.smartcleaner.pro.domain.model.LargeFile
import java.text.SimpleDateFormat
import java.util.*

class LargeFileAdapter : ListAdapter<LargeFile, LargeFileAdapter.LargeFileViewHolder>(LargeFileDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LargeFileViewHolder {
        val binding = ItemLargeFileBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return LargeFileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LargeFileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LargeFileViewHolder(
        private val binding: ItemLargeFileBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(largeFile: LargeFile) {
            binding.fileName.text = largeFile.file.name
            binding.filePath.text = largeFile.file.parent ?: ""
            binding.fileSize.text = formatFileSize(largeFile.size)
            binding.fileType.text = largeFile.fileType.uppercase()
            binding.lastModified.text = formatDate(largeFile.lastModified)

            binding.checkbox.isChecked = largeFile.isSelected
            binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
                largeFile.isSelected = isChecked
            }
        }

        private fun formatFileSize(size: Long): String {
            val units = arrayOf("B", "KB", "MB", "GB", "TB")
            var fileSize = size.toDouble()
            var unitIndex = 0

            while (fileSize >= 1024 && unitIndex < units.size - 1) {
                fileSize /= 1024
                unitIndex++
            }

            return "%.1f %s".format(fileSize, units[unitIndex])
        }

        private fun formatDate(timestamp: Long): String {
            val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
            return sdf.format(Date(timestamp))
        }
    }
}

class LargeFileDiffCallback : DiffUtil.ItemCallback<LargeFile>() {
    override fun areItemsTheSame(oldItem: LargeFile, newItem: LargeFile): Boolean {
        return oldItem.file.absolutePath == newItem.file.absolutePath
    }

    override fun areContentsTheSame(oldItem: LargeFile, newItem: LargeFile): Boolean {
        return oldItem == newItem
    }
}