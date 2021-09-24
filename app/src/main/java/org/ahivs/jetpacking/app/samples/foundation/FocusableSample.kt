package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester


@Composable
fun FocusableSample() {
    // initialize focus reference to be able to request focus programmatically
    val focusRequester = remember { FocusRequester() }
    // MutableInteractionSource to track changes of the component's interactions (like "focused")
    val interactionSource = remember { MutableInteractionSource() }

    // text below will change when we focus it via button click
    val isFocused = interactionSource.collectIsFocusedAsState().value
    val text = if (isFocused) {
        "Focused! tap anywhere to free the focus"
    } else {
        "Bring focus to me by tapping the button below!"
    }
    Column {
        // this Text will change it's text parameter depending on the presence of a focus
        Text(
            text = text,
            modifier = Modifier
                // add focusRequester modifier before the focusable (or even in the parent)
                .focusRequester(focusRequester)
                .focusable(interactionSource = interactionSource)
        )
        Button(onClick = { focusRequester.requestFocus() }) {
            Text("Bring focus to the text above")
        }
    }
}