package com.deputy.android.ds.views.text

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import com.deputy.android.ds.R
import com.deputy.android.ds.extensions.obtainAttributes
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class InputText : TextInputLayout {

    companion object {
        private val enterKeyCodes = listOf(KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_DPAD_CENTER)
        const val DELAY_MS = 100L
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, R.attr.textInputStyle) {
        readAttributes(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        readAttributes(attrs)
    }

    private val editText: TextInputEditText

    private var allowKeyboardEnter: Boolean = false
    private var dismissKeyboardOnEnter: Boolean = false
    private var onEnterPressed: (() -> Unit)? = null
    private var errorTextDisplayDelay: Long = 0

    private val enterKeyCodes = listOf(KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_DPAD_CENTER)

    private var pendingErrorText: CharSequence? = null

    private val errorHandler = Handler()

    private val setPendingErrorText = Runnable {
        super.setError(pendingErrorText)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_input_text, this, true)
        editText = findViewById(R.id.txt_edit)
        isErrorEnabled = true

        editText.setOnKeyListener { view, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_UP && enterKeyCodes.contains(keyCode)) {
                onEnterPressed?.invoke()
                if (dismissKeyboardOnEnter) {
                    hideKeyboard()
                }
                true
            } else {
                false
            }
        }
    }

    fun setText(text: String?) {
        editText.setText(text)
    }

    fun getText(): String? {
        return editText.text?.toString()
    }

    override fun setError(errorText: CharSequence?) {

        errorHandler.removeCallbacks(setPendingErrorText)
        if (errorText.isNullOrBlank()) {
            super.setError(errorText)
        } else {
            pendingErrorText = errorText
            errorHandler.postDelayed(setPendingErrorText, errorTextDisplayDelay)
        }
    }

    fun addTextChangedListener(watcher: TextWatcher) {
        editText.addTextChangedListener(watcher)
    }

    fun maxLines(max: Int) {
        editText.maxLines = max
        editText.isSingleLine = max == 1
    }

    fun onKeyboardEnter(onEnterPressed: (() -> Unit)?) {
        this.onEnterPressed = onEnterPressed
    }

    private fun readAttributes(attrs: AttributeSet) {
        context.obtainAttributes(attrs, R.styleable.InputText) { typedArray ->
            val maxLines = typedArray.getInt(R.styleable.InputText_maxLines, Integer.MAX_VALUE)
            editText.maxLines = maxLines
            editText.isSingleLine = maxLines == 1

            allowKeyboardEnter = typedArray.getBoolean(R.styleable.InputText_allowKeyboardEnter, false)
            isErrorEnabled = typedArray.getBoolean(R.styleable.InputText_errorEnabled, true)
            dismissKeyboardOnEnter = typedArray.getBoolean(R.styleable.InputText_dismissKeyboardOnEnter, false)
            errorTextDisplayDelay = typedArray.getInt(R.styleable.InputText_errorTextDisplayDelay, 0).toLong()

            if (typedArray.getBoolean(R.styleable.InputText_focusAndShowKeyboard, false)) {
                editText.setSelectAllOnFocus(true)
                editText.postDelayed({
                    editText.requestFocus()
                    showKeyboard()
                }, DELAY_MS)
            }
            if (typedArray.getBoolean(R.styleable.InputText_sentenceCase, false)) {
                editText.setRawInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES)
            }
        }
    }

    @Suppress("TooGenericExceptionCaught")
    private fun hideKeyboard() {
        try {
            val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
        } catch (e: Exception) {
            // no-op no need to crash because of this
        }
    }

    @Suppress("TooGenericExceptionCaught")
    private fun showKeyboard() {
        try {
            Handler().post {
                val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
            }
        } catch (e: Exception) {
            // no-op no need to crash because of this
        }
    }

    interface KeyboardEnterPressed : () -> Unit

    @InverseBindingMethods(
        InverseBindingMethod(
            type = InputText::class,
            attribute = "text",
            event = "textAttrChanged",
            method = "getText"
        )
    )
    object Binding {
        @JvmStatic
        @BindingAdapter(value = ["textAttrChanged"])
        fun setListener(inputText: InputText, listener: InverseBindingListener?) {
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

        @JvmStatic
        @InverseBindingAdapter(attribute = "text")
        fun getText(input: InputText): String? {
            return input.getText()
        }

        @JvmStatic
        @BindingAdapter("text")
        fun setText(inputText: InputText, text: String?) {
            if (text != inputText.getText()) {
                inputText.setText(text)
            }
        }

        @JvmStatic
        @BindingAdapter("onKeyboardEnter")
        fun bindKeyboardEnter(inputText: InputText, onEnterPressed: KeyboardEnterPressed) {
            inputText.onEnterPressed = onEnterPressed
        }
    }
}
