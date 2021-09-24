package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp

@Composable
fun BorderSample() {
    Text(
        "Text with  square border",
        modifier = Modifier.border(4.dp, Color.Magenta).padding(10.dp)
    )
}

@Composable
fun BorderSampleWithBrush() {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color.Red, Color.Blue, Color.Green),
        startX = 0.0f,
        endX = 500.0f,
        tileMode = TileMode.Repeated
    )
    Text(
        "Text with gradient border",
        modifier = Modifier.border(width = 2.dp, brush = gradientBrush, shape = CircleShape)
            .padding(10.dp)
    )
}

@Composable
fun BorderSampleWithDataClass() {
    Text(
        "Text with gradient border",
        modifier = Modifier.border(
            border = BorderStroke(2.dp, Color.Blue),
            shape = CutCornerShape(8.dp)
        ).padding(10.dp)
    )
}