package org.ahivs.jetpacking.app.animation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CrossFadeScreen {

    enum class DemoScene {
        Text,
        Icon
    }

    @Preview
    @Composable
    fun CrossFadeDemo() {
        var scene by remember { mutableStateOf(DemoScene.Text) }

        Column {
            Button(onClick = {
                scene = when (scene) {
                    DemoScene.Text -> DemoScene.Icon
                    DemoScene.Icon -> DemoScene.Text
                }
            }) {
                Text(text = "TOGGLE")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Crossfade(scene) { scene ->
                when (scene) {
                    DemoScene.Text -> Text(
                        text = "Phone",
                        fontSize = 32.sp
                    )
                    DemoScene.Icon -> Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Phone"
                    )
                }
            }
        }
    }
}