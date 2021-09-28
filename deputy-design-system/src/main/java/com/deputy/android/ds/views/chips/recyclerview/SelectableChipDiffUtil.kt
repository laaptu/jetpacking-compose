package com.deputy.android.ds.views.chips.recyclerview

import androidx.recyclerview.widget.DiffUtil

class SelectableChipDiffUtil(
    private val old: List<SelectableChipItem>,
    private val new: List<SelectableChipItem>,
    private val oldSelected: List<SelectableChipItem>,
    private val newSelected: List<SelectableChipItem>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = old[oldItemPosition]
        val newItem = new[newItemPosition]
        return oldItem.getName() == newItem.getName()
    }

    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = old[oldItemPosition]
        val newItem = new[newItemPosition]
        val previouslySelected = oldSelected.contains(oldItem)
        val nowSelected = newSelected.contains(newItem)
        return previouslySelected == nowSelected
    }
}
