package com.smartcleaner.pro.presentation.ui.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartcleaner.pro.databinding.ItemToolBinding

class ToolsAdapter(
    private val onToolClick: (Tool) -> Unit
) : ListAdapter<Tool, ToolsAdapter.ToolViewHolder>(ToolDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolViewHolder {
        val binding = ItemToolBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ToolViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToolViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ToolViewHolder(
        private val binding: ItemToolBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onToolClick(getItem(position))
                }
            }
        }

        fun bind(tool: Tool) {
            binding.toolIcon.setImageResource(tool.iconResId)
            binding.toolTitle.text = tool.title
            binding.toolDescription.text = tool.description
        }
    }
}

data class Tool(
    val id: String,
    val title: String,
    val description: String,
    val iconResId: Int
)

class ToolDiffCallback : DiffUtil.ItemCallback<Tool>() {
    override fun areItemsTheSame(oldItem: Tool, newItem: Tool): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Tool, newItem: Tool): Boolean {
        return oldItem == newItem
    }
}