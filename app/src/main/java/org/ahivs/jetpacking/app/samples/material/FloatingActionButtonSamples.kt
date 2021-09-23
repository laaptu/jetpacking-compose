package org.ahivs.jetpacking.app.samples

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SimpleFab() {
    FloatingActionButton(onClick = { /*do something*/ }) {
        Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
    }
}

@Composable
fun SimpleExtendedFabNoIcon() {
    ExtendedFloatingActionButton(
        text = { Text("EXTENDED") },
        onClick = {}
    )
}

@Preview
@Composable
fun SimpleExtendedFabWithIcon() {
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
        text = { Text("ADD TO BASKET") },
        onClick = { /*do something*/ }
    )
}

@Preview
@Composable
fun FluidExtendedFab() {
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
        text = { Text("FLUID FAB") },
        onClick = { /*do something*/ },
        modifier = Modifier.fillMaxWidth()
    )
}