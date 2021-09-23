package org.ahivs.jetpacking.app.samples.animation

import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ColorAnimationSample() {
    @Composable
    fun ColorAnimation(primary: Boolean) {
        // Animates to primary or secondary color, depending on whether [primary] is true
        // [animateState] returns the current animation value in a State<Color> in this example. We
        // use the State<Color> object as a property delegate here.
        val color: Color by animateColorAsState(
            if (primary) MaterialTheme.colors.primary else MaterialTheme.colors.secondary
        )
        Box(modifier = Modifier.background(color))
    }
}

fun AnimatableColor() {
    @Composable
    fun animate(
        targetValue: Color,
        animationSpec: AnimationSpec<Color>,
        onFinished: (Color) -> Unit
    ): Color {
        // Creates an Animatable of Color, and remembers it.
        val color = remember { Animatable(targetValue) }
        val finishedListener = rememberUpdatedState(onFinished)
        // Launches a new coroutine whenever the target value or animation spec has changed. This
        // automatically cancels the previous job/animation.
        LaunchedEffect(targetValue, animationSpec) {
            color.animateTo(targetValue, animationSpec)
            // Invokes finished listener. This line will not be executed if the job gets canceled
            // halfway through an animation.
            finishedListener.value(targetValue)
        }
        return color.value
    }
}