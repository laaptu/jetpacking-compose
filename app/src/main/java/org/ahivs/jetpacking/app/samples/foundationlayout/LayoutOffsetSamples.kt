package org.ahivs.jetpacking.app.samples.foundationlayout

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun OffsetModifier() {
    // This text will be offset (10.dp, 20.dp) from the center of the available space. In the
    // right-to-left context, the offset will be (-10.dp, 20.dp).
    Text(
        "Layout offset modifier sample",
        Modifier.fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .offset(10.dp, 20.dp)
    )
}

@Preview
@Composable
fun AbsoluteOffsetModifier() {
    // This text will be offset (10.dp, 20.dp) from the center of the available space.
    Text(
        "Layout offset modifier sample",
        Modifier.fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .absoluteOffset(10.dp, 20.dp)
    )
}

@Preview
@Composable
fun OffsetPxModifier() {
    // This text will be offset in steps of 10.dp from the top left of the available space in
    // left-to-right context, and from top right in right-to-left context.
    var offset by remember { mutableStateOf(0) }
    Text(
        "Layout offset modifier sample",
        Modifier
            .clickable { offset += 10 }
            .offset { IntOffset(offset, offset) }
    )
}

@Preview
@Composable
fun AbsoluteOffsetPxModifier() {
    // This text will be offset in steps of 10.dp from the top left of the available space.
    var offset by remember { mutableStateOf(0) }
    Text(
        "Layout offset modifier sample",
        Modifier
            .clickable { offset += 10 }
            .absoluteOffset { IntOffset(offset, offset) }
    )
}