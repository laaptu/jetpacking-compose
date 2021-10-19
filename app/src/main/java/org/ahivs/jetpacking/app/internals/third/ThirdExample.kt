package org.ahivs.jetpacking.app.internals.third

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.ahivs.jetpacking.app.internals.LogCompositions

@Preview
@Composable
fun MyComponent() {
    var counter by remember { mutableStateOf(0) }
    var color by remember {
        mutableStateOf(false)
    }

    LogCompositions("JetpackCompose.app", "MyComposable function")

    Button(
        onClick = { color = !color },
        shape = if (color) {
            MaterialTheme.shapes.small
        } else {
            MaterialTheme.shapes.large
        }
    ) {
        LogCompositions("JetpackCompose.app", "ButtonScope")
        CustomText(
            text = "Counter: $counter"
        )
    }
}

@Composable
fun SomeButton(
    onClick: () -> Unit = {},
    color: Boolean = false,
    content: @Composable RowScope.() -> Unit
) {
    val shape = if (color) {
        MaterialTheme.shapes.small
    } else {
        MaterialTheme.shapes.large
    }
    println("## Jetpack Change color = $color")
    LogCompositions("JetpackCompose.app", "Button")
    Button(
        onClick = onClick,
        shape = shape,
        content = content
    )
}

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
) {
    LogCompositions("JetpackCompose.app", "CustomText function")

    Text(
        text = text,
        modifier = modifier.padding(32.dp),
        style = TextStyle(
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline,
            fontFamily = FontFamily.Monospace
        )
    )
}

//2021-10-11 22:22:10.191 4431-4431/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: MyComposable function 0
//2021-10-11 22:22:10.237 4431-4431/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: Button 0
//2021-10-11 22:22:10.237 4431-4431/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: CustomText function 0
//2021-10-11 22:22:22.893 4431-4431/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: Button 1
//2021-10-11 22:22:22.893 4431-4431/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: CustomText function 1
//2021-10-11 22:22:24.744 4431-4431/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: Button 2
//2021-10-11 22:22:24.745 4431-4431/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: CustomText function 2