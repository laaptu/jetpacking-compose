package com.deputy.android.ds.views.recyclerview.decorations

import android.content.Context
import android.view.View
import com.deputy.android.ds.R
import kotlin.math.max
import kotlin.math.min

abstract class FadeUnderlineWithStickyHeaderDecoration(
    context: Context
) : StickySectionHeaderDecoration(context) {

    private val underline: View by lazy {
        view.findViewById<View>(R.id.view_underline)
    }

    override fun updateViewBasedOnPosition(view: View, unpinnedPosition: Float, adapterIndex: Int) {
        val max = view.measuredHeight.toFloat()
        val min = 0f
        val pcnt = unpinnedPosition.percentBetween(min, max)
        val alpha = 1f - pcnt
        underline.alpha = alpha
    }

    private fun Float.percentBetween(min: Float, max: Float): Float {
        val pos = max(min(max, this), max(this, min))
        return pos / max
    }
}
