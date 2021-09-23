package org.ahivs.jetpacking.app.samples.foundationlayout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SpacerExample() {
    Row {
        Box(Modifier.size(100.dp).background(Color.Red))
        Spacer(Modifier.width(20.dp))
        Box(Modifier.size(100.dp).background(Color.Magenta))
        Spacer(Modifier.weight(1f))
        Box(Modifier.size(100.dp).background(Color.Black))
    }
}