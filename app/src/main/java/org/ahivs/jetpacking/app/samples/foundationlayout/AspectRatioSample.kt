package org.ahivs.jetpacking.app.samples.foundationlayout

import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SimpleAspectRatio() {
    Box(
        Modifier
            .width(100.dp)
            .aspectRatio(2f)
            .background(Color.Green))
}