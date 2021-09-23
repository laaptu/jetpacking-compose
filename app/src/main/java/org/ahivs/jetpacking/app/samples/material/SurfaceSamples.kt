package org.ahivs.jetpacking.app.samples

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SurfaceSample() {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Text("Text color is `onBackground`")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ClickableSurfaceSample() {
    var count by remember { mutableStateOf(0) }
    Surface(
        onClick = { count++ },
        color = MaterialTheme.colors.background
    ) {
        Text("Clickable surface Text with `onBackground` color and count: $count")
    }
}