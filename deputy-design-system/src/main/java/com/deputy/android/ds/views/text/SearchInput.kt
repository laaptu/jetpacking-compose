package com.deputy.android.ds.views.text

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import com.deputy.android.ds.R
import com.deputy.android.ds.extensions.getColorFromAttrRes
import com.deputy.android.ds.extensions.obtainAttributes

class SearchInput : FrameLayout {

    private val input: EditText by lazy {
        findViewById<EditText>(R.id.edit_input)
    }

    private var hintText: String? = null
        set(value) {
            field = value
            input.hint = value
        }

    private var icon: Drawable? = null
        set(value) {
            field = value
            input.setCompoundDrawablesWithIntrinsicBounds(value, null, null, null)
        }

    var onUpdate: ((CharSequence) -> Unit)? = null

    var text: String?
        set(value) {
            input.setText(value, TextView.BufferType.EDITABLE)
        }
        get() = input.text.toString()

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(attrs)
    }

    fun addTextChangedListener(watcher: TextWatcher) {
        input.addTextChangedListener(watcher)
    }

    private fun initView(attrs: AttributeSet? = null) {
        inflate(context, R.layout.view_search_input, this)
        setBackgroundResource(R.drawable.bg_search_input)

        var hintTextTemp = resources.getString(R.string.search_input_hint)
        var iconTemp = resources.getDrawable(R.drawable.ic_search)
        var iconPaddingTemp = resources.getDimensionPixelSize(R.dimen.search_input_default_icon_padding)
        context.obtainAttributes(attrs, R.styleable.SearchInput) { typedArray ->
            hintTextTemp = typedArray.getString(R.styleable.SearchInput_hint) ?: hintTextTemp
            iconTemp = typedArray.getDrawable(R.styleable.SearchInput_icon) ?: iconTemp
            iconPaddingTemp = typedArray.getDimensionPixelSize(R.styleable.SearchInput_icon_padding, iconPaddingTemp)
        }

        val textColor = context.getColorFromAttrRes(R.attr.deputyTextSecondaryLabel)
        iconTemp.setColorFilter(textColor, PorterDuff.Mode.SRC_IN)
        hintText = hintTextTemp
        icon = iconTemp
        input.compoundDrawablePadding = iconPaddingTemp
        input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    onUpdate?.invoke(it)
                }
            }
        })
    }

    @InverseBindingMethods(
        InverseBindingMethod(
            type = SearchInput::class,
            attribute = "text",
            event = "textAttrChanged",
            method = "getText"
        )
    )
    object Binding {
        @JvmStatic
        @BindingAdapter("text")
        fun bindText(input: SearchInput, text: String?) {
            if (input.text != text) {
                input.text = text
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["textAttrChanged"])
        fun setListener(inputText: SearchInput, listener: InverseBindingListener?) {
            if (listener != null) {
                inputText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    }

                    override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    }

                    override fun afterTextChanged(editable: Editable) {
                        listener.onChange()
                    }
                })
            }
        }
    }
}
