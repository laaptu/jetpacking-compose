package com.deputy.android.ds.views.chips

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.deputy.android.ds.R
import com.deputy.android.ds.extensions.obtainAttributes
import com.deputy.android.ds.views.WrappedView

class SelectedChip : WrappedView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        handleAttrs(attrs)
    }

    override val wrappedView: TextView by lazy {
        findViewById<TextView>(R.id.txt_chip)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_selected_chip, this, true)
    }

    fun setText(text: CharSequence?) {
        wrappedView.text = text
    }

    fun getText(): CharSequence = wrappedView.text

    private fun handleAttrs(attrs: AttributeSet) {
        context.obtainAttributes(attrs, R.styleable.SelectedChip) { typedArray ->
            wrappedView.text = typedArray.getText(R.styleable.SelectedChip_text)
        }
    }
}
