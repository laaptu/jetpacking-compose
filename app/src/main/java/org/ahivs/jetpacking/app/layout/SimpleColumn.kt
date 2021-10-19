package org.ahivs.jetpacking.app.layout

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->

        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
        layout(constraints.maxWidth, constraints.maxHeight) {
            var height = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(0, height)
                height += placeable.height
            }
        }
    }
}

@Preview
@Composable
fun PlaceColumn() {
    MyOwnColumn {
        Text("Hello")
        Text("How are you doing")
        Text("Doing good")
    }
}