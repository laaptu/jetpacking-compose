package com.deputy.android.ds.views.chips.recyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deputy.android.ds.R
import com.deputy.android.ds.extensions.getAttribute
import com.deputy.android.ds.utils.PropertyDelegate
import com.deputy.android.ds.views.recyclerview.decorations.HorizontalSpacingDecoration

open class SelectableChipRecyclerView : RecyclerView {

    constructor(context: Context) : super(context) {
        spacingStart = 0
        spacingEnd = 0
    }

    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        spacingStart = context.getAttribute(attrs, R.styleable.SelectableChipRecycler) { typedArray ->
            typedArray.getDimensionPixelSize(R.styleable.SelectableChipRecycler_spacingStart, 0)
        }

        spacingEnd = context.getAttribute(attrs, R.styleable.SelectableChipRecycler) { typedArray ->
            typedArray.getDimensionPixelSize(R.styleable.SelectableChipRecycler_spacingEnd, 0)
        }

        horizontalSpacing = HorizontalSpacingDecoration(
            spacingStart,
            context.resources.getDimensionPixelSize(R.dimen.selectable_chip_spacing),
            spacingEnd
        )
    }

    private val selectableItemAdapter = SelectableChipAdapter()
    private val spacingStart: Int
    private val spacingEnd: Int

    protected var horizontalSpacing: ItemDecoration? = null
        set(value) {
            field?.let {
                removeItemDecoration(it)
            }
            if (value != null) {
                addItemDecoration(value)
            }
            field = value
        }

    var items: List<SelectableChipItem> = selectableItemAdapter.selected
        get() = selectableItemAdapter.selected
        set(value) {
            field = value
            selectableItemAdapter.update(value, selectableItemAdapter.selected)
        }

    var selected: List<SelectableChipItem> = selectableItemAdapter.selected
        get() = selectableItemAdapter.selected
        set(value) {
            field = value
            selectableItemAdapter.update(selectableItemAdapter.items, value)
        }

    fun update(items: List<SelectableChipItem>, selected: List<SelectableChipItem>) {
        selectableItemAdapter.update(items, selected)
    }

    var onSelected: ((SelectableChipItem) -> Unit)? by PropertyDelegate(selectableItemAdapter::onSelected)

    init {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = selectableItemAdapter
    }
}
