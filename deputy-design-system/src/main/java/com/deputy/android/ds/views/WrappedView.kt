package com.deputy.android.ds.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

abstract class WrappedView : FrameLayout {

    constructor (context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )
    protected abstract val wrappedView: View

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        wrappedView.measure(widthMeasureSpec, heightMeasureSpec)

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width = when (widthMode) {
            MeasureSpec.EXACTLY -> widthSize
            MeasureSpec.AT_MOST -> Math.min(widthSize, wrappedView.measuredWidth)
            MeasureSpec.UNSPECIFIED -> wrappedView.measuredWidth
            else -> 0
        }

        val height = when (heightMode) {
            MeasureSpec.EXACTLY -> heightSize
            MeasureSpec.AT_MOST -> Math.min(heightSize, wrappedView.measuredHeight)
            MeasureSpec.UNSPECIFIED -> wrappedView.measuredHeight
            else -> 0
        }

        setMeasuredDimension(width, height)
    }
}
