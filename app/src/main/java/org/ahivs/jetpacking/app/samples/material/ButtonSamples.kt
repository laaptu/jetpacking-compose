package org.ahivs.jetpacking.app.samples

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ButtonSample() {
    Button(onClick = { /* Do something! */ }) {
        Text("Button")
    }
}

@Preview
@Composable
fun OutlinedButtonSample() {
    OutlinedButton(onClick = { /* Do something! */ }) {
        Text("Outlined Button")
    }
}

@Preview
@Composable
fun TextButtonSample() {
    TextButton(onClick = { /* Do something! */ }) {
        Text("Text Button")
    }
}

@Preview
@Composable
fun ButtonWithIconSample() {
    Button(onClick = { /* Do something! */ }) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}