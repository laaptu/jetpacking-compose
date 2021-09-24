package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun DeterminateProgressSemanticsSample() {
    val progress = 0.5f // emulate progress from some state
    Box(
        Modifier
            .progressSemantics(progress)
            .size((progress * 100).dp, 4.dp)
            .background(color = Color.Cyan)
    )
}

@Preview
@Composable
fun IndeterminateProgressSemanticsSample() {
    Box(Modifier.progressSemantics().background(color = Color.Cyan)) {
        Text("Operation is on progress")
    }
}