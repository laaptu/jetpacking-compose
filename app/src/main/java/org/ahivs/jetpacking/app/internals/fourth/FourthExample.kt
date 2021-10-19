package org.ahivs.jetpacking.app.internals.fourth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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

    LogCompositions("JetpackCompose.app", "MyComposable function")

    val readingCounter = counter
    CustomButton(onClick = { counter++ }) {
        LogCompositions("JetpackCompose.app", "CustomButton scope")
        CustomText(
            text = "Counter: $counter",
            modifier = Modifier
                .clickable {
                    counter++
                },
        )
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    LogCompositions("JetpackCompose.app", "CustomButton function")
    Button(onClick = onClick, modifier = Modifier.padding(16.dp)) {
        LogCompositions("JetpackCompose.app", "Button function")
        content()
    }
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