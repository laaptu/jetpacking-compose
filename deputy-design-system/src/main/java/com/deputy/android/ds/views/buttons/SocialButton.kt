package com.deputy.android.ds.views.buttons

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.deputy.android.ds.R
import com.deputy.android.ds.extensions.obtainAttributes
import kotlinx.android.synthetic.main.view_social_button.view.*

class SocialButton : LinearLayout {

    constructor(context: Context?) : super(context) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet? = null) {
        FrameLayout.inflate(context, R.layout.view_social_button, this)
        context.obtainAttributes(attrs, R.styleable.SocialButton) { typedArray ->
            text.text = typedArray.getText(R.styleable.SocialButton_customText)

            val color = typedArray.getColor(R.styleable.SocialButton_customTextColor, 0)
            text.setTextColor(color)

            val iconId = typedArray.getResourceId(R.styleable.SocialButton_customIcon, 0)
            if (iconId != 0) {
                icon.setImageDrawable(ContextCompat.getDrawable(context, iconId))
            }
        }
    }
}
