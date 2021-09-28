package com.deputy.android.ds.views.toast

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import com.deputy.android.ds.databinding.ViewInfoBinding

class InfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    companion object {
        const val FADE_IN_DURATION = 200L
        const val FADE_OUT_DURATION = 300L
        const val FADE_OUT_START_DELAY = 2000
    }

    private lateinit var binding: ViewInfoBinding
    private lateinit var fadeInAnimator: ObjectAnimator
    private lateinit var fadeOutAnimator: ObjectAnimator
    private var fadeOutStartDelay = FADE_OUT_START_DELAY.toLong()

    init {
        setupView()
        readAttributes(attrs)
    }

    private fun setupView() {
        setBackgroundResource(android.R.color.transparent)
        binding = ViewInfoBinding.inflate(LayoutInflater.from(context), this, true)
        fadeInAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f).apply {
            duration = FADE_IN_DURATION
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator?) {
                    this@InfoView.visibility = View.VISIBLE
                    this@InfoView.alpha = 0f
                }
            })
        }

        fadeOutAnimator = ObjectAnimator.ofFloat(this, "alpha", 1f, 0f).apply {
            duration = FADE_OUT_DURATION
            startDelay = fadeOutStartDelay
            interpolator = DecelerateInterpolator()
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    this@InfoView.visibility = View.GONE
                }

                override fun onAnimationStart(animation: Animator?) {
                    this@InfoView.alpha = 1f
                }
            })
        }
        visibility = View.GONE
    }

    fun show() {
        if (fadeOutAnimator.isRunning) {
            fadeOutAnimator.cancel()
        }
        fadeInAnimator.start()
        fadeOutAnimator.start()
    }

    fun setText(text: String) {
        binding.txtTitle.text = text
    }

    @SuppressLint("ResourceType")
    private fun readAttributes(attrs: AttributeSet?) {
        context.obtainStyledAttributes(attrs,
            intArrayOf(android.R.attr.text, android.R.attr.duration)).apply {
            try {
                val titleText = getText(0) ?: ""
                setText(titleText.toString())
                fadeOutStartDelay = getInt(1, FADE_OUT_START_DELAY).toLong()
            } finally {
                recycle()
            }
        }
    }
}
