package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DarkThemeSample() {
    val dark = isSystemInDarkTheme()
    val color = if (dark) Color.White else Color.Black
    Box {
        Box(Modifier.size(50.dp).background(color = color))
    }
}