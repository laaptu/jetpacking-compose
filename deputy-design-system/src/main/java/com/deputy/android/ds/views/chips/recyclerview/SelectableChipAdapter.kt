package com.deputy.android.ds.views.chips.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.deputy.android.ds.R
import com.deputy.android.ds.databinding.RecyclerItemSelectableChipBinding

class SelectableChipAdapter : RecyclerView.Adapter<SelectableChipAdapter.SelectableItemViewHolder>() {

    var items: List<SelectableChipItem> = emptyList()
        private set

    var selected: List<SelectableChipItem> = emptyList()
        private set

    var onSelected: ((SelectableChipItem) -> Unit)? = null

    fun update(items: List<SelectableChipItem>, selected: List<SelectableChipItem>) {
        val diff = DiffUtil.calculateDiff(SelectableChipDiffUtil(this.items, items, this.selected, selected))
        this.items = items
        this.selected = selected
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectableItemViewHolder {
        val binding: RecyclerItemSelectableChipBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_item_selectable_chip,
            parent,
            false
        )
        return SelectableItemViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SelectableItemViewHolder, position: Int) {
        holder.bind(items[position], selected)
    }

    inner class SelectableItemViewHolder(val binding: RecyclerItemSelectableChipBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SelectableChipItem, selected: List<SelectableChipItem>) {
            binding.name = item.getName()
            binding.selected = selected.contains(item)
            binding.onClick = View.OnClickListener {
                onSelected?.invoke(item)
            }
            binding.executePendingBindings()
        }
    }
}
