package com.deputy.android.ds.views.recyclerview.decorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class StackedHeaderDecoration : RecyclerView.ItemDecoration() {

    protected fun getTopOffsetOf(childView: View, parent: RecyclerView, state: RecyclerView.State): Int {
        val rect = Rect()
        (0 until parent.itemDecorationCount).forEach {
            val decoration = parent.getItemDecorationAt(it)
            decoration.getItemOffsets(rect, childView, parent, state)
            if (decoration == this) {
                return rect.top
            }
        }
        return rect.top
    }
}
