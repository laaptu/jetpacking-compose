package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.MutatorMutex
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch


fun mutatorMutexStateObject() {
    @Stable
    class ScrollState(position: Int = 0) {
        private var _position by mutableStateOf(position)
        var position: Int
            get() = _position.coerceAtMost(range)
            set(value) {
                _position = value.coerceIn(0, range)
            }

        private var _range by mutableStateOf(0)
        var range: Int
            get() = _range
            set(value) {
                _range = value.coerceAtLeast(0)
            }

        private val mutatorMutex = MutatorMutex()

        /**
         * Only one caller to [scroll] can be in progress at a time.
         */
        suspend fun <R> scroll(
            block: suspend () -> R
        ): R = mutatorMutex.mutate(block = block)
    }

    /**
     * Arbitrary animations can be defined as extensions using only public API
     */
    suspend fun ScrollState.animateTo(target: Int) {
        scroll {
            animate(from = position, to = target) { newPosition ->
                position = newPosition
            }
        }
    }

    /**
     * Presents two buttons for animating a scroll to the beginning or end of content.
     * Pressing one will cancel any current animation in progress.
     */
    @Composable
    fun ScrollControls(scrollState: ScrollState) {
        Row {
            val scope = rememberCoroutineScope()
            Button(onClick = { scope.launch { scrollState.animateTo(0) } }) {
                Text("Scroll to beginning")
            }
            Button(onClick = { scope.launch { scrollState.animateTo(scrollState.range) } }) {
                Text("Scroll to end")
            }
        }
    }
}


fun mutatorMutexStateObjectWithReceiver() {
    @Stable
    class ScrollState(position: Int = 0) {
        private var _position = mutableStateOf(position)
        val position: Int by _position

        private val mutatorMutex = MutatorMutex()

        /**
         * Only [block] in a call to [scroll] may change the value of [position].
         */
        suspend fun <R> scroll(
            block: suspend MutableState<Int>.() -> R
        ): R = mutatorMutex.mutateWith(_position, block = block)
    }
}

@Suppress("UNUSED_PARAMETER")
private suspend fun animate(from: Int, to: Int, onFrame: (position: Int) -> Unit): Unit = TODO()

@Suppress("UNUSED_PARAMETER")
@Composable
private fun Button(onClick: () -> Unit, content: @Composable () -> Unit): Unit = TODO()