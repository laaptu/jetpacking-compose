package com.deputy.android.ds.views.progressbars

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.deputy.android.ds.R
import com.deputy.android.ds.views.WrappedView
import me.zhanghai.android.materialprogressbar.MaterialProgressBar

class IndeterminateProgressBar : WrappedView {

    constructor (context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override val wrappedView: View by lazy {
        findViewById<MaterialProgressBar>(R.id.progress_bar_wrapped)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_indeterminate_progress_bar, this, true)
    }
}
