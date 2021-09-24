package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DrawBackgroundColor() {
    Text(
        "Text with background",
        Modifier.background(color = Color.Magenta).padding(10.dp)
    )
}

@Composable
fun DrawBackgroundShapedBrush() {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color.Red, Color.Blue, Color.Green),
        startX = 0.0f,
        endX = 500.0f
    )
    Text(
        "Text with gradient back",
        Modifier.background(brush = gradientBrush, shape = CutCornerShape(8.dp))
            .padding(10.dp)
    )
}