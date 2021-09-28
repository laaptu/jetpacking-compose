package com.deputy.android.ds.views.recyclerview.decorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class OptionalHeaderDecoration : StackedHeaderDecoration() {

    abstract fun drawHeaderBetween(topAdapterIndex: Int, bottomAdapterIndex: Int): Boolean
    abstract fun headerHeightFor(adapterIndex: Int, recyclerViewWidth: Int, recyclerViewHeight: Int): Int

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val index = parent.getChildAdapterPosition(view)
        if (index > -1 && drawHeaderBetween(index - 1, index)) {
            addHeaderSpace(outRect, index, parent.width, parent.height)
        }
    }

    private fun addHeaderSpace(outRect: Rect, adapterIndex: Int, recyclerViewWidth: Int, recyclerViewHeight: Int) {
        val headerHeight = headerHeightFor(adapterIndex, recyclerViewWidth, recyclerViewHeight)
        outRect.top = outRect.top + headerHeight
    }
}
