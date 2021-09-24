package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun BasicTextFieldSample() {
    var value by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue())
    }
    BasicTextField(
        value = value,
        onValueChange = {
            // it is crucial that the update is fed back into BasicTextField in order to
            // see updates on the text
            value = it
        }
    )
}


@Composable
fun BasicTextFieldWithStringSample() {
    var value by rememberSaveable { mutableStateOf("initial value") }
    BasicTextField(
        value = value,
        onValueChange = {
            // it is crucial that the update is fed back into BasicTextField in order to
            // see updates on the text
            value = it
        }
    )
}


@Composable
@OptIn(ExperimentalFoundationApi::class)
fun PlaceholderBasicTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("initial value") }
    Box {
        BasicTextField(
            value = value,
            onValueChange = { value = it }
        )
        if (value.isEmpty()) {
            Text(text = "Placeholder")
        }
    }
}


@Composable
@OptIn(ExperimentalFoundationApi::class)
fun TextFieldWithIconSample() {
    var value by rememberSaveable { mutableStateOf("initial value") }
    BasicTextField(
        value = value,
        onValueChange = { value = it },
        decorationBox = { innerTextField ->
            // Because the decorationBox is used, the whole Row gets the same behaviour as the
            // internal input field would have otherwise. For example, there is no need to add a
            // Modifier.clickable to the Row anymore to bring the text field into focus when user
            // taps on a larger text field area which includes paddings and the icon areas.
            Row(
                Modifier
                    .background(Color.LightGray, RoundedCornerShape(percent = 30))
                    .padding(16.dp)
            ) {
                Icon(Icons.Default.MailOutline, contentDescription = null)
                Spacer(Modifier.width(16.dp))
                innerTextField()
            }
        }
    )
}