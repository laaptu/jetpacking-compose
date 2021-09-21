package org.ahivs.jetpacking.app.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class AnimateStateScreen {

    @Composable
    fun AnimateAsStateDemo() {
        var isBlue by remember {
            mutableStateOf(true)
        }
        val color by animateColorAsState(
            targetValue = if (isBlue) Color.Blue else Color.Green
        )
        Column {
            Button(onClick = { isBlue = !isBlue }) {
                Text(text = "CHANGE COLOR")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .height(128.dp)
                    .width(128.dp)
                    .background(color)
            )
        }
    }

    @Preview
    @Composable
    fun PreviewDemo() {
        AnimateAsStateDemo()
    }
}