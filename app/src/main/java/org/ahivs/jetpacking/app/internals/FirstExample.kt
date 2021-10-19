package org.ahivs.jetpacking.app.internals

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MyComponent() {
    var counter by remember { mutableStateOf(0) }

    LogCompositions("JetpackCompose.app", "MyComposable function")

    CustomText(
        text = "Counter: $counter",
        modifier = Modifier
            .clickable {
                counter++
            }
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

//2021-10-11 22:16:58.757 4304-4304/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: MyComposable function 0
//2021-10-11 22:16:58.758 4304-4304/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: CustomText function 0
//2021-10-11 22:17:30.877 4304-4304/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: MyComposable function 1
//2021-10-11 22:17:30.877 4304-4304/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: CustomText function 1
//2021-10-11 22:17:33.960 4304-4304/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: MyComposable function 2
//2021-10-11 22:17:33.960 4304-4304/org.ahivs.jetpacking.app D/JetpackCompose.app: Compositions: CustomText function 2