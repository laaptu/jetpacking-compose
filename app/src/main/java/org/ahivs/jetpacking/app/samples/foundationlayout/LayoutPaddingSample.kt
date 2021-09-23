package org.ahivs.jetpacking.app.samples.foundationlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PaddingModifier() {
    Box(Modifier.background(color = Color.Gray)) {
        Box(
            Modifier.padding(start = 20.dp, top = 30.dp, end = 20.dp, bottom = 30.dp)
                .size(50.dp)
                .background(Color.Blue)
        )
    }
}

@Preview
@Composable
fun SymmetricPaddingModifier() {
    Box(Modifier.background(color = Color.Gray)) {
        Box(
            Modifier
                .padding(horizontal = 20.dp, vertical = 30.dp)
                .size(50.dp)
                .background(Color.Blue)
        )
    }
}

@Preview
@Composable
fun PaddingAllModifier() {
    Box(Modifier.background(color = Color.Gray)) {
        Box(Modifier.padding(all = 20.dp).size(50.dp).background(Color.Blue))
    }
}

@Preview
@Composable
fun PaddingValuesModifier() {
    val innerPadding = PaddingValues(top = 10.dp, start = 15.dp)
    Box(Modifier.background(color = Color.Gray)) {
        Box(Modifier.padding(innerPadding).size(50.dp).background(Color.Blue))
    }
}

@Preview
@Composable
fun AbsolutePaddingModifier() {
    Box(Modifier.background(color = Color.Gray)) {
        Box(
            Modifier.absolutePadding(left = 20.dp, top = 30.dp, right = 20.dp, bottom = 30.dp)
                .size(50.dp)
                .background(Color.Blue)
        )
    }
}