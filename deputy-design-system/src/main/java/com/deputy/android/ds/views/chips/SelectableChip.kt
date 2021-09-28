package com.deputy.android.ds.views.chips

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.deputy.android.ds.R
import com.deputy.android.ds.extensions.obtainAttributes
import com.deputy.android.ds.views.WrappedView

class SelectableChip : WrappedView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        handleAttrs(attrs)
    }

    override val wrappedView: TextView by lazy {
        findViewById<TextView>(R.id.txt_chip)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_selectable_chip, this, true)
    }

    fun setText(text: CharSequence?) {
        wrappedView.text = text
    }

    fun getText(): CharSequence = wrappedView.text

    override fun setOnClickListener(l: OnClickListener?) {
        wrappedView.setOnClickListener(l)
    }

    override fun isSelected(): Boolean {
        return wrappedView.isSelected
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
        wrappedView.isSelected = selected
    }

    private fun handleAttrs(attrs: AttributeSet) {
        context.obtainAttributes(attrs, R.styleable.SelectableChip) { typedArray ->
            wrappedView.text = typedArray.getText(R.styleable.SelectableChip_text)
            wrappedView.isSelected = typedArray.getBoolean(R.styleable.SelectableChip_selected, false)
        }
    }
}
