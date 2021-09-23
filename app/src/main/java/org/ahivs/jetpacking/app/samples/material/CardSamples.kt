package org.ahivs.jetpacking.app.samples

import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun CardSample() {
    Card {
        Text("Card Content")
    }
}

@ExperimentalMaterialApi
@Composable
fun ClickableCardSample() {
    var count by remember { mutableStateOf(0) }
    Card(onClick = { count++ }) {
        Text("Clickable card content with count: $count")
    }
}