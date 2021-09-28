package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalFoundationApi::class)

fun stateMapSample() {
    @Composable
    fun NamesAndAges() {
        var name by remember { mutableStateOf("name") }
        var saying by remember { mutableStateOf("saying") }
        val sayings = remember {
            mutableStateMapOf(
                "Caesar" to "Et tu, Brute?",
                "Hamlet" to "To be or not to be",
                "Richard III" to "My kingdom for a horse"
            )
        }

        Column {
            Row {
                BasicTextField(
                    value = name,
                    onValueChange = { name = it }
                )
                BasicTextField(
                    value = saying,
                    onValueChange = { saying = it }
                )
                Button(onClick = { sayings[name] = saying }) {
                    Text("Add")
                }
                Button(onClick = { sayings.remove(name) }) {
                    Text("Remove")
                }
            }
            Text("Sayings:")
            Column {
                for (entry in sayings) {
                    Text("${entry.key} says '${entry.value}'")
                }
            }
        }
    }
}