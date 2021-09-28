package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalFoundationApi::class)
fun stateSample() {
    @Composable
    fun LoginScreen() {
        var username by remember { mutableStateOf("user") }
        var password by remember { mutableStateOf("pass") }

        fun login() = Api.login(username, password)

        BasicTextField(
            value = username,
            onValueChange = { username = it }
        )
        BasicTextField(
            value = password,
            onValueChange = { password = it }
        )
        Button(onClick = { login() }) {
            Text("Login")
        }
    }
}
