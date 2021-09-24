package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun IndicationSample() {
    val interactionSource = remember { MutableInteractionSource() }
    Column {
        Text(
            text = "Click me and my neighbour will indicate as well!",
            modifier = Modifier
                // clickable will dispatch events using MutableInteractionSource and show ripple
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple()
                ) {
                    /**do something */
                }
                .padding(10.dp)
        )
        Spacer(Modifier.requiredHeight(10.dp))
        Text(
            text = "I'm neighbour and I indicate when you click the other one",
            modifier = Modifier
                // this element doesn't have a click, but will show default indication from the
                // CompositionLocal as it accepts the same MutableInteractionSource
                .indication(interactionSource, LocalIndication.current)
                .padding(10.dp)
        )
    }
}