package com.deputy.android.ds.views.checkboxes

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.deputy.android.ds.R

@Suppress("MagicNumber")
class AvatarCheckBox : FrameLayout {

    private val tick by lazy {
        findViewById<ImageView>(R.id.img_checked)
    }

    private val avatar by lazy {
        findViewById<ImageView>(R.id.img_avatar)
    }

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(attrs)
        tick.rotationY = 180f
    }

    fun setAvatarUrl(url: String) {
        Glide.with(context)
            .load(url)
            .placeholder(context.getDrawable(R.drawable.ic_avatar))
            .fallback(context.getDrawable(R.drawable.ic_avatar))
            .apply(RequestOptions().circleCrop())
            .into(avatar)
    }

    fun setChecked(checked: Boolean) {
        if (checked) {
            animateToChecked()
        } else {
            animateToUnchecked()
        }
    }

    private val animTime = 500L

    private fun animateToChecked() {

        val currentProgress = 1 - avatar.rotationY / -180f
        avatar.animate()
            .withLayer()
            .rotationY(-180f)
            .setDuration((animTime * currentProgress).toLong())
            .setUpdateListener {
                avatar.visibility = if (avatar.rotationY <= -90f) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            }.start()

        tick.animate()
            .withLayer()
            .rotationY(0f)
            .setDuration(animTime)
            .setUpdateListener {
                tick.visibility = if (tick.rotationY < 90) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }.start()
    }

    private fun animateToUnchecked() {
        val currentProgress = 1 - tick.rotationY / 180f
        avatar.animate()
            .withLayer()
            .rotationY(0f)
            .setDuration((animTime * currentProgress).toLong())
            .setUpdateListener {
                avatar.visibility = if (avatar.rotationY <= -90f) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            }.start()

        tick.animate()
            .withLayer()
            .rotationY(180f)
            .setDuration((animTime * currentProgress).toLong())
            .setUpdateListener {
                tick.visibility = if (tick.rotationY < 90) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }.start()
    }

    private fun initView(attrs: AttributeSet? = null) {
        LinearLayout.inflate(context, R.layout.view_avatar_checkbox, this)
        setSelectableForeground()
    }

    private fun setSelectableForeground() {
        val outValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
        foreground = context.getDrawable(R.drawable.ripple_avatar_checkbox)
    }
}
