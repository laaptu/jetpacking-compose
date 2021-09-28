package com.deputy.android.ds.views.progressbars

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.Interpolator
import android.widget.ProgressBar
import com.deputy.android.ds.R
import com.deputy.android.ds.animations.OnAnimationEndListener
import com.deputy.android.ds.extensions.obtainAttributes

/**
 * Progress Bar that never reach the end unless [finish] has been called.
 * IMPORTANT: call [setExpectedProgressTime] before calling [start].
 */
class EndlessProgressBar : ProgressBar {

    companion object {
        private const val finishAnimationDuration = 500L
        private const val minProgress = 0
        private const val maxProgress = 1000
        private const val keyProgress1 = 800
        private const val keyProgress2 = 950
    }

    private var currentAnimation: ValueAnimator? = null
    private var animationDuration = 0L

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0, R.style.DsProgressBar) {
        initView(attrs)
    }

    /**
     * First, animates progress from [minProgress] to [keyProgress1]
     * using [animationDuration] value set from [setExpectedProgressTime] function.
     * Next, animates progress to [keyProgress2] using [animationDuration] value set from [setExpectedProgressTime] function.
     * Make sure you call [setExpectedProgressTime] before calling this method.
     */
    fun start() {
        require(animationDuration > 0) {
            "Animation duration is less than zero. Did you forget to call 'setExpectedProgressTime'?"
        }
        startProgressAnimation(from = minProgress, to = keyProgress1, duration = animationDuration, endListener = {
            startProgressAnimation(from = progress, to = keyProgress2, duration = animationDuration)
        })
    }

    /**
     * Animates progress from current position to [maxProgress]
     * and calls [onAnimationCompleted] when animation is completed.
     */
    fun finish(onAnimationCompleted: (() -> Unit)? = null) {
        currentAnimation?.removeAllListeners()
        currentAnimation?.cancel()
        startProgressAnimation(from = progress, to = maxProgress, duration = finishAnimationDuration,
            interpolator = AccelerateInterpolator(),
            endListener = onAnimationCompleted
        )
    }

    /**
     * Call this method before [start] to set average time you expect progress to take.
     * It effects how fast progress reaches [keyProgress1] and [keyProgress2].
     */
    fun setExpectedProgressTime(timeMillis: Long) {
        animationDuration = timeMillis
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        // we need to set height here for v22 because drawable background doesn't change height
        layoutParams.height = resources.getDimension(R.dimen.ds_horizontal_progress_bar_height).toInt()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        currentAnimation?.removeAllListeners()
        currentAnimation?.cancel()
    }

    private fun initView(attrs: AttributeSet? = null) {
        max = maxProgress
        context.obtainAttributes(attrs, R.styleable.EndlessProgressBar) { typedArray ->
            animationDuration = typedArray.getInteger(R.styleable.EndlessProgressBar_expectedProgressTime, 0).toLong()
            if (typedArray.getBoolean(R.styleable.EndlessProgressBar_autoStart, false)) {
                start()
            }
        }
    }

    private fun startProgressAnimation(
        from: Int,
        to: Int,
        duration: Long,
        interpolator: Interpolator = DecelerateInterpolator(),
        endListener: (() -> Unit)? = null
    ) {
        val valueAnimator = ValueAnimator.ofInt(from, to)
        valueAnimator.addUpdateListener { animator: ValueAnimator ->
            progress = animator.animatedValue as Int
        }
        valueAnimator.duration = duration
        valueAnimator.interpolator = interpolator
        valueAnimator.addListener(object : OnAnimationEndListener {
            override fun onAnimationEnd(animation: Animator) {
                endListener?.invoke()
            }
        })
        valueAnimator.start()
        currentAnimation = valueAnimator
    }
}
