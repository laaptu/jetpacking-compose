package org.ahivs.jetpacking.app.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
class AnimateVisibilityScreen {

    @Preview
    @Composable
    fun AnimatedVisibilityDemo() {
        var visible by remember { mutableStateOf(true) }

        Column {
            Button(onClick = { visible = !visible }) {
                Text(text = if (visible) "HIDE" else "SHOW")
            }

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedVisibility(
                visible
            ) {
                Box(
                    modifier = Modifier
                        .size(128.dp)
                        .background(Color.Blue)
                )
            }
        }
    }
}