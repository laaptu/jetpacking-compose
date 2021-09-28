package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData


@Composable
fun LiveDataSample(liveData: LiveData<String>) {
    val value: String? by liveData.observeAsState()
    Text("Value is $value")
}


@Composable
fun LiveDataWithInitialSample(liveData: LiveData<String>) {
    val value: String by liveData.observeAsState("initial")
    Text("Value is $value")
}