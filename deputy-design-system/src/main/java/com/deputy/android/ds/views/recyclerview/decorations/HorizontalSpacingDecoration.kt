package com.deputy.android.ds.views.recyclerview.decorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalSpacingDecoration : RecyclerView.ItemDecoration {

    private val spacingStart: Int
    private val spacing: Int
    private val spacingEnd: Int

    constructor(spacing: Int) {
        this.spacingStart = 0
        this.spacing = spacing
        this.spacingEnd = 0
    }

    constructor(spacingStart: Int, spacing: Int) {
        this.spacingStart = spacingStart
        this.spacing = spacing
        this.spacingEnd = 0
    }

    constructor(spacingStart: Int, spacing: Int, spacingEnd: Int) {
        this.spacingStart = spacingStart
        this.spacing = spacing
        this.spacingEnd = spacingEnd
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val index = parent.getChildAdapterPosition(view)
        when (index) {
            0 -> {
                outRect.left += spacingStart
                outRect.right += spacing
            }
            state.itemCount - 1 -> outRect.right += spacingEnd
            else -> outRect.right += spacing
        }
    }
}
