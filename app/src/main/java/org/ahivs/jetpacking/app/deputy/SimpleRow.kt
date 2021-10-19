package org.ahivs.jetpacking.app.deputy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import org.ahivs.jetpacking.app.R
import org.ahivs.jetpacking.app.samples.foundation.ImageSample
import kotlin.math.roundToInt

@Preview
@Composable
fun SimpleRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Hi how are you ffffffffffffffffffffff?",
            modifier = Modifier.weight(1f)
        )
        Text("How are you doing", modifier = Modifier.weight(1f))
        Text("Hey There", modifier = Modifier.weight(1f))
    }
}

@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    horizontalGap: Dp = 0.dp,
    verticalGap: Dp = 0.dp,
    alignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable () -> Unit,
) = Layout(modifier = modifier, content = content) { measurables, constraints ->
    val horizontalGapPx = horizontalGap.roundToPx()
    val verticalGapPx = verticalGap.roundToPx()

    val rows = mutableListOf<Row>()
    var rowConstraints = constraints
    var rowPlaceables = mutableListOf<Placeable>()

    measurables.forEach { measurable ->
        val placeable = measurable.measure(Constraints())
        if (placeable.measuredWidth !in rowConstraints.minWidth..rowConstraints.maxWidth) {
            rows += Row(rowPlaceables, horizontalGapPx)
            rowConstraints = constraints
            rowPlaceables = mutableListOf()
        }
        val consumedWidth = placeable.measuredWidth + horizontalGapPx
        rowConstraints = rowConstraints.offset(horizontal = -consumedWidth)
        rowPlaceables.add(placeable)
    }
    rows += Row(rowPlaceables, horizontalGapPx)

    val width = constraints.maxWidth
    val height = (rows.sumOf { row -> row.height } + (rows.size - 1) * verticalGapPx)
        .coerceAtMost(constraints.maxHeight)

    layout(width, height) {
        var y = 0
        rows.forEach { row ->
            val offset = alignment.align(row.width, width, layoutDirection)
            var x = offset
            row.placeables.forEach { placeable ->
                placeable.placeRelative(x, y)
                x += placeable.width + horizontalGapPx
            }
            y += row.height + verticalGapPx
        }
    }
}

private class Row(
    val placeables: List<Placeable>,
    val horizontalGapPx: Int,
) {
    val width by lazy(mode = LazyThreadSafetyMode.NONE) {
        placeables.sumOf { it.width } + (placeables.size - 1) * horizontalGapPx
    }

    val height by lazy(mode = LazyThreadSafetyMode.NONE) {
        placeables.maxOfOrNull { it.height } ?: 0
    }
}

@Composable
private fun Preview(alignment: Alignment.Horizontal) {
    Box(Modifier.fillMaxWidth()) {
        FlowRow(
            horizontalGap = 8.dp,
            verticalGap = 8.dp,
            alignment = alignment,
        ) {
            repeat(17) { index ->
                Row {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_profile),
                        contentDescription = null
                    )
                    Text(text = index.toString() + "This is $index  item")
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewAlignStart() = Preview(alignment = Alignment.Start)

@Preview
@Composable
private fun PreviewAlignCenter() = Preview(alignment = Alignment.CenterHorizontally)

@Preview
@Composable
private fun PreviewAlignEnd() = Preview(alignment = Alignment.End)