package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Suppress("UNREACHABLE_CODE", "CanBeVal", "UNUSED_VARIABLE")

fun snapshotFlowSample() {
    // Define Snapshot state objects
    var greeting by mutableStateOf("Hello")
    var person by mutableStateOf("Adam")

    // ...

    // Create a flow that will emit whenever our person-specific greeting changes
    val greetPersonFlow = snapshotFlow { "$greeting, $person" }

    // ...

    val collectionScope: CoroutineScope = TODO("Use your scope here")

    // Collect the flow and offer greetings!
    collectionScope.launch {
        greetPersonFlow.collect {
            println(greeting)
        }
    }

    // ...

    // Change snapshot state; greetPersonFlow will emit a new greeting
    Snapshot.withMutableSnapshot {
        greeting = "Ahoy"
        person = "Sean"
    }
}