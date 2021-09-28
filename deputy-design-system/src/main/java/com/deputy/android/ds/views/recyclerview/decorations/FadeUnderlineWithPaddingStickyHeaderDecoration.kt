package com.deputy.android.ds.views.recyclerview.decorations

import android.content.Context
import android.view.View
import com.deputy.android.ds.R
import kotlin.math.max
import kotlin.math.min

abstract class FadeUnderlineWithPaddingStickyHeaderDecoration(
    context: Context,
    private val padding: Int
) : StickySectionHeaderDecoration(context) {

    private val underline: View by lazy {
        view.findViewById<View>(R.id.view_underline)
    }

    override fun updateViewBasedOnPosition(view: View, unpinnedPosition: Float, adapterIndex: Int) {
        if (drawHeaderBetween(adapterIndex - 1, adapterIndex)) {
            val min = padding * -1
            val pcnt = (unpinnedPosition / min)
            val alpha = max(min(pcnt, 1f), 0f)
            underline.alpha = alpha
        } else {
            underline.alpha = 1f
        }
    }
}
