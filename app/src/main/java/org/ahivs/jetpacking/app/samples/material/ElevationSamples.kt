package org.ahivs.jetpacking.app.samples

import androidx.compose.material.LocalAbsoluteElevation
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Suppress("UNUSED_VARIABLE", "NAME_SHADOWING")
@Composable
fun AbsoluteElevationSample() {
    Surface(elevation = 4.dp) {
        // This will equal 4.dp
        val elevation = LocalAbsoluteElevation.current
        Surface(elevation = 2.dp) {
            // This will equal 6.dp (4 + 2)
            val elevation = LocalAbsoluteElevation.current
        }
    }
}