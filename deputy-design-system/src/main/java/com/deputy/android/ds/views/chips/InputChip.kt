package com.deputy.android.ds.views.chips

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.deputy.android.ds.R
import com.deputy.android.ds.extensions.getColorFromAttrRes
import com.deputy.android.ds.extensions.obtainAttributes

class InputChip : LinearLayout {

    private val mainText: TextView by lazy { findViewById<TextView>(R.id.main_text) }
    private val closeIcon: View by lazy { findViewById<View>(R.id.close_icon) }
    private val icon: ImageView by lazy { findViewById<ImageView>(R.id.icon) }

    var text: CharSequence
        get() = mainText.text
        set(value) {
            mainText.text = value
        }

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(attrs)
    }

    fun setCloseIconVisibility(isVisible: Boolean) {
        closeIcon.visibility = if (isVisible) VISIBLE else GONE
    }

    fun setOnCloseIconClickListener(block: (view: InputChip) -> Unit) {
        closeIcon.setOnClickListener { block.invoke(this) }
    }

    fun setIcon(drawable: Drawable?) {
        icon.setImageDrawable(drawable)
        icon.visibility = if (drawable != null) VISIBLE else GONE
    }

    private fun initView(attrs: AttributeSet? = null) {
        inflate(context, R.layout.view_input_chip, this)

        background = ContextCompat.getDrawable(context, R.drawable.bg_input_chip)
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(
            resources.getDimensionPixelSize(R.dimen.input_chip_padding_start),
            resources.getDimensionPixelSize(R.dimen.input_chip_padding_top),
            resources.getDimensionPixelSize(R.dimen.input_chip_padding_end),
            resources.getDimensionPixelSize(R.dimen.input_chip_padding_bottom)
        )
        if (attrs != null) {
            context.obtainAttributes(attrs, R.styleable.InputChip) { typedArray ->
                mainText.text = typedArray.getText(R.styleable.InputChip_text)
                mainText.setTextColor(typedArray.getColor(R.styleable.InputChip_textColor,
                    context.getColorFromAttrRes(R.attr.deputyTextPrimaryLabel)))
                setCloseIconVisibility(typedArray.getBoolean(R.styleable.InputChip_canRemove, true))
                setIcon(typedArray)
                isSelected = typedArray.getBoolean(R.styleable.InputChip_selected, false)
            }
        } else {
            setIcon(null)
        }
    }

    private fun setIcon(typedArray: TypedArray) {
        setIcon(typedArray.getDrawable(R.styleable.InputChip_icon))
        val iconSize = typedArray.getDimensionPixelSize(R.styleable.InputChip_iconSize, -1)
        if (iconSize != -1) {
            setIconSize(iconSize)
        }
        if (typedArray.getBoolean(R.styleable.InputChip_iconBackground, false)) {
            val padding = resources.getDimensionPixelSize(R.dimen.input_chip_icon_padding)
            icon.setPadding(padding, padding, padding, padding)
        }
    }

    private fun setIconSize(iconSize: Int) {
        icon.layoutParams = LayoutParams(iconSize, iconSize)
        closeIcon.layoutParams = LayoutParams(iconSize, iconSize)
    }
}
