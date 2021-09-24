package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.calculateCentroid
import androidx.compose.foundation.gestures.calculateCentroidSize
import androidx.compose.foundation.gestures.calculatePan
import androidx.compose.foundation.gestures.calculateRotation
import androidx.compose.foundation.gestures.calculateZoom
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

@Composable

fun DetectTransformGestures() {
    var angle by remember { mutableStateOf(0f) }
    var zoom by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    Box(
        Modifier.offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .graphicsLayer(
                scaleX = zoom,
                scaleY = zoom,
                rotationZ = angle
            )
            .background(Color.Blue)
            .pointerInput(Unit) {
                detectTransformGestures(
                    onGesture = { _, pan, gestureZoom, gestureRotate ->
                        angle += gestureRotate
                        zoom *= gestureZoom
                        offsetX += pan.x
                        offsetY += pan.y
                    }
                )
            }
            .fillMaxSize()
    )
}

@Composable

fun CalculateRotation() {
    var angle by remember { mutableStateOf(0f) }
    Box(
        Modifier
            .graphicsLayer(rotationZ = angle)
            .background(Color.Blue)
            .pointerInput(Unit) {
                forEachGesture {
                    awaitPointerEventScope {
                        awaitFirstDown()
                        do {
                            val event = awaitPointerEvent()
                            val rotation = event.calculateRotation()
                            angle += rotation
                        } while (event.changes.any { it.pressed })
                    }
                }
            }
            .fillMaxSize()
    )
}

@Composable

fun CalculateZoom() {
    var zoom by remember { mutableStateOf(1f) }
    Box(
        Modifier
            .graphicsLayer(scaleX = zoom, scaleY = zoom)
            .background(Color.Blue)
            .pointerInput(Unit) {
                forEachGesture {
                    awaitPointerEventScope {
                        awaitFirstDown()
                        do {
                            val event = awaitPointerEvent()
                            zoom *= event.calculateZoom()
                        } while (event.changes.any { it.pressed })
                    }
                }
            }
            .fillMaxSize()
    )
}

@Composable

fun CalculatePan() {
    val offsetX = remember { mutableStateOf(0f) }
    val offsetY = remember { mutableStateOf(0f) }
    Box(
        Modifier
            .offset { IntOffset(offsetX.value.roundToInt(), offsetY.value.roundToInt()) }
            .graphicsLayer()
            .background(Color.Blue)
            .pointerInput(Unit) {
                forEachGesture {
                    awaitPointerEventScope {
                        awaitFirstDown()
                        do {
                            val event = awaitPointerEvent()
                            val offset = event.calculatePan()
                            offsetX.value += offset.x
                            offsetY.value += offset.y
                        } while (event.changes.any { it.pressed })
                    }
                }
            }
            .fillMaxSize()
    )
}

@Composable

fun CalculateCentroidSize() {
    var centroidSize by remember { mutableStateOf(0f) }
    var position by remember { mutableStateOf(Offset.Zero) }
    Box(
        Modifier
            .drawBehind {
                // Draw a circle where the gesture is
                drawCircle(Color.Blue, centroidSize, center = position)
            }
            .pointerInput(Unit) {
                forEachGesture {
                    awaitPointerEventScope {
                        awaitFirstDown().also {
                            position = it.position
                        }
                        do {
                            val event = awaitPointerEvent()
                            val size = event.calculateCentroidSize()
                            if (size != 0f) {
                                centroidSize = event.calculateCentroidSize()
                            }
                            val centroid = event.calculateCentroid()
                            if (centroid != Offset.Unspecified) {
                                position = centroid
                            }
                        } while (event.changes.any { it.pressed })
                    }
                }
            }
            .fillMaxSize()
    )
}