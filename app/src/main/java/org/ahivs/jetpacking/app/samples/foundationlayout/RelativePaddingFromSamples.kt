package org.ahivs.jetpacking.app.samples.foundationlayout

import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PaddingFromSample() {
    // We want to have 30.sp distance from the top of the layout box to the baseline of the
    // first line of text.
    val distanceToBaseline = 30.sp
    // We convert the 30.sp value to dps, which is required for the paddingFrom API.
    val distanceToBaselineDp = with(LocalDensity.current) { distanceToBaseline.toDp() }
    // The result will be a layout with 30.sp distance from the top of the layout box to the
    // baseline of the first line of text.
    Text(
        text = "This is an example.",
        modifier = Modifier.paddingFrom(FirstBaseline, before = distanceToBaselineDp)
    )
}

@Preview
@Composable
fun PaddingFromBaselineSampleDp() {
    // We want to have 30.dp distance from the top of the layout box to the baseline of the
    // first line of text, and a 40.dp distance from the bottom of the layout box to the baseline
    // of the last line of text. Note it is good practice to specify these distances in sp for font
    // scaling, which can be done with the other overload.
    val distanceToFirstBaseline = 30.dp
    val distanceFromLastBaseline = 40.dp
    Text(
        text = "This line has the first baseline.\nThis line has the last baseline.",
        modifier = Modifier.paddingFromBaseline(distanceToFirstBaseline, distanceFromLastBaseline)
    )
}

@Preview
@Composable
fun PaddingFromBaselineSampleTextUnit() {
    // We want to have 30.sp distance from the top of the layout box to the baseline of the
    // first line of text, and a 40.sp distance from the bottom of the layout box to the baseline
    // of the last line of text.
    val distanceToFirstBaseline = 30.sp
    val distanceFromLastBaseline = 40.sp
    Text(
        text = "This line has the first baseline.\nThis line has the last baseline.",
        modifier = Modifier.paddingFromBaseline(distanceToFirstBaseline, distanceFromLastBaseline)
    )
}