package com.deputy.android.ds.animations

import android.animation.Animator

interface OnAnimationEndListener : Animator.AnimatorListener {

    override fun onAnimationRepeat(animation: Animator) {
        // ignored
    }

    override fun onAnimationCancel(animation: Animator) {
        // ignored
    }

    override fun onAnimationStart(animation: Animator) {
        // ignored
    }
}
