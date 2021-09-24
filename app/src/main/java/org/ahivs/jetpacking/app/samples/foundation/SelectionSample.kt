package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer


@Composable
fun SelectionSample() {
    SelectionContainer {
        Column {
            Text("Text 1")
            Text("Text 2")
            Text("טקסט 3")
        }
    }
}


@Composable
fun DisableSelectionSample() {
    SelectionContainer {
        Column {
            Text("Text 1")

            DisableSelection {
                Text("Text 2")
                Text("טקסט 3")
            }

            Text("Text 3")
        }
    }
}