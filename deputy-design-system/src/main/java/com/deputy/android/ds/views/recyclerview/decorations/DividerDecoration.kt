package com.deputy.android.ds.views.recyclerview.decorations

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.deputy.android.ds.R

open class DividerDecoration : RecyclerView.ItemDecoration {

    companion object {
        protected const val DEFAULT_PADDING = 0
        private const val HEX_MAX_ALPHA = 255
    }

    private val divider: Drawable
    private val drawBottom: Boolean
    private var paddingTop = 0
    private var paddingBottom = 0
    private var paddingLeft = 0
    private var paddingRight = 0

    constructor(
        context: Context,
        resourceId: Int = R.drawable.recycler_divider_primary,
        drawBottom: Boolean = true,
        paddingTop: Int = DEFAULT_PADDING,
        paddingBottom: Int = DEFAULT_PADDING,
        paddingLeft: Int = DEFAULT_PADDING,
        paddingRight: Int = DEFAULT_PADDING
    ) {
        divider = ContextCompat.getDrawable(context, resourceId)!!
        this.drawBottom = drawBottom
        this.paddingTop = paddingTop
        this.paddingBottom = paddingBottom
        this.paddingLeft = paddingLeft
        this.paddingRight = paddingRight
    }

    constructor(
        context: Context,
        resourceId: Int = R.drawable.recycler_divider_primary,
        drawBottom: Boolean = true
    ) : this(
        context,
        resourceId,
        drawBottom = drawBottom,
        paddingTop = DEFAULT_PADDING,
        paddingBottom = DEFAULT_PADDING,
        paddingLeft = DEFAULT_PADDING,
        paddingRight = DEFAULT_PADDING
    )

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val index = parent.getChildAdapterPosition(view)
        val size = state.itemCount
        if (shouldDraw(index, size)) {
            outRect.bottom = outRect.bottom + divider.intrinsicHeight + paddingTop + paddingBottom
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = paddingLeft
        val right = parent.width - paddingRight
        val dividerHeight = divider.intrinsicHeight.toFloat()
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val index = parent.getChildAdapterPosition(child)
            if (index >= 0 && shouldDraw(index, parent.adapter!!.itemCount)) {
                draw(c, child, left, right, dividerHeight)
            }
        }
    }

    protected open fun shouldDraw(index: Int, size: Int): Boolean {
        if (index < 0) {
            return false
        }
        return drawBottom || index != size - 1
    }

    private fun draw(c: Canvas, child: View, left: Int, right: Int, dividerHeight: Float) {
        val params = child.layoutParams as RecyclerView.LayoutParams

        val top = child.bottom + params.bottomMargin + paddingTop
        val bottom = (top + dividerHeight).toInt()
        divider.alpha = Math.floor(HEX_MAX_ALPHA * child.alpha.toDouble()).toInt()
        divider.setBounds(left, top, right, bottom)
        divider.draw(c)
    }
}
