package com.deputy.android.ds.views.buttons

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.deputy.android.ds.R
import com.google.android.material.button.MaterialButton

class CallToActionButton : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    private val button = MaterialButton(context)

    init {
        val padding = context.resources.getDimensionPixelSize(R.dimen.ds_call_to_action_padding)
        setPadding(padding, padding, padding, padding)
        setBackgroundColor(themeBackgroundColor())
        foregroundGravity = Gravity.CENTER
        addView(button)
    }

    fun setText(text: CharSequence) {
        button.text = text
    }

    fun setText(resourceId: Int) {
        button.setText(resourceId)
    }

    override fun setOnClickListener(listener: View.OnClickListener?) {
        button.setOnClickListener(listener)
    }

    override fun setEnabled(enabled: Boolean) {
        button.isEnabled = enabled
    }

    private fun themeBackgroundColor(): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.windowBackground, typedValue, true)
        val colorRange: IntRange = TypedValue.TYPE_FIRST_COLOR_INT..TypedValue.TYPE_LAST_COLOR_INT
        return if (colorRange.contains(typedValue.type)) {
            // windowBackground is a color
            typedValue.data
        } else {
            // windowBackground is a not color, probably a drawable
            Color.TRANSPARENT
        }
    }
}
