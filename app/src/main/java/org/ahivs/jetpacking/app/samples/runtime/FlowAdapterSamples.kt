package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow


@Composable
fun FlowWithInitialSample(flow: Flow<String>) {
    val value: String by flow.collectAsState("initial")
    Text("Value is $value")
}


@Composable
fun StateFlowSample(stateFlow: StateFlow<String>) {
    val value: String by stateFlow.collectAsState()
    Text("Value is $value")
}