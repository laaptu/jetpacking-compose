@file:JvmName("GeneralUtils")
package com.deputy.android.ds.extensions

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt

/**
 * This function gets TypedArray holding the attribute values, invokes [block] and recycle TypedArray
 * [block] won't be invoked if [set] is null
 */
inline fun Context.obtainAttributes(set: AttributeSet?, attrs: IntArray, block: (TypedArray) -> Unit) {
    set?.let {
        val typedArray = obtainStyledAttributes(set, attrs)
        try {
            block(typedArray)
        } finally {
            typedArray.recycle()
        }
    }
}

inline fun <T> Context.getAttribute(set: AttributeSet, attrs: IntArray, block: (TypedArray) -> T): T {
    val typedArray = obtainStyledAttributes(set, attrs)
    return try {
        block(typedArray)
    } finally {
        typedArray.recycle()
    }
}

@ColorInt
fun Context.getColorFromAttrRes(@AttrRes attrRes: Int): Int {
    val typedValue = TypedValue()
    val theme = this.theme
    theme.resolveAttribute(attrRes, typedValue, true)
    return typedValue.data
}
