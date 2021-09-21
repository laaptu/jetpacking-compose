package org.ahivs.jetpacking.app.animation

import android.widget.Space
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class AnimateTransitionScreen {
    enum class BoxState {
        Small,
        Large
    }

    @Preview
    @Composable
    fun UpdateTransitionDemo() {
        var boxState by remember {
            mutableStateOf(BoxState.Small)
        }

        val transition = updateTransition(targetState = boxState, label = "Transition box")

        val color by transition.animateColor(label = "Box Color") { state ->
            when (state) {
                BoxState.Small -> Color.Blue
                BoxState.Large -> Color.Yellow
            }
        }

        val size by transition.animateDp(
            label = "Box Size",
            transitionSpec = {
                if (targetState == BoxState.Large) {
                    androidx.compose.animation.core.spring(stiffness = 50f)
                } else {
                    androidx.compose.animation.core.spring(stiffness = 90f)
                }
            }
        ) { state ->
            when (state) {
                BoxState.Small -> 64.dp
                BoxState.Large -> 128.dp
            }
        }

        Column {
            Button(onClick = {
                boxState = when (boxState) {
                    BoxState.Small -> BoxState.Large
                    BoxState.Large -> BoxState.Small
                }
            }) {
                Text("CHANGE SIZE")
            }
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .background(color)
                    .width(size)
                    .height(size)
            )
        }
    }

}