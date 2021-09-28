package com.deputy.android.ds.views.recyclerview.decorations

import android.graphics.Canvas
import android.graphics.RectF
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class StickyHeaderDecoration : OptionalHeaderDecoration() {

    abstract fun getHeaderView(adapterIndex: Int, parent: RecyclerView): View?
    abstract fun updateViewBasedOnPosition(view: View, unpinnedPosition: Float, adapterIndex: Int)

    final override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount

        for (childViewIndex in 0 until childCount) {

            val child = parent.getChildAt(childViewIndex)
            val adapterIndex = parent.getChildAdapterPosition(child)

            val unpinnedPosition = unpinnedPosition(child, parent, state)
            val view = getHeaderView(adapterIndex, parent)?.also {
                updateViewBasedOnPosition(it, unpinnedPosition.toFloat(), adapterIndex)
            }
            if (childViewIndex == 0) {
                view?.drawAsStickyHeader(adapterIndex, child, canvas, unpinnedPosition)
            } else if (drawHeaderBetween(adapterIndex - 1, adapterIndex)) {
                view?.drawAsHeaderOf(child, canvas, unpinnedPosition)
            }
        }
    }

    private fun View.drawAsStickyHeader(adapterIndex: Int, child: View, canvas: Canvas, unpinnedPosition: Int) {
        val nextChildHasHeader = drawHeaderBetween(adapterIndex, adapterIndex + 1)
        val pinnedPosition = Math.max(unpinnedPosition, 0)
        val position = if (nextChildHasHeader) {
            Math.min(pinnedPosition, (child.bottom - this.measuredHeight)).toFloat()
        } else {
            pinnedPosition.toFloat()
        }
        draw(this, canvas, atPosition = position, alpha = child.alpha)
    }

    private fun View.drawAsHeaderOf(child: View, onto: Canvas, unpinnedPosition: Int) {
        draw(this, onto, atPosition = Math.max(unpinnedPosition.toFloat(), 0f), alpha = child.alpha)
    }

    private fun unpinnedPosition(child: View, parent: RecyclerView, state: RecyclerView.State): Int {
        return child.top - getTopOffsetOf(child, parent, state)
    }

    @Suppress("MagicNumber")
    private fun draw(view: View, onto: Canvas, atPosition: Float, alpha: Float) {
        onto.save()
        val drawRegion = RectF(0f, atPosition, view.measuredWidth.toFloat(), atPosition + view.measuredHeight)
        onto.saveLayerAlpha(drawRegion, (alpha * 255).toInt())
        onto.translate(0f, atPosition)
        view.draw(onto)
        onto.restore()
    }
}
