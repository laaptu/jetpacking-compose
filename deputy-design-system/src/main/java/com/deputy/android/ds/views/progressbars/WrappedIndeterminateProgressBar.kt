package com.deputy.android.ds.views.progressbars

import android.content.Context
import android.graphics.drawable.Drawable
import android.provider.Settings
import android.util.AttributeSet
import me.zhanghai.android.materialprogressbar.MaterialProgressBar

private class WrappedIndeterminateProgressBar : MaterialProgressBar {

    constructor (context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override fun setIndeterminateDrawable(drawable: Drawable?) {
        super.setIndeterminateDrawable(if (hideIndeterminateDrawable()) null else drawable)
    }

    private fun hideIndeterminateDrawable(): Boolean {
        return Settings.Global.getFloat(context.contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE, 1f) == 0f
    }
}
