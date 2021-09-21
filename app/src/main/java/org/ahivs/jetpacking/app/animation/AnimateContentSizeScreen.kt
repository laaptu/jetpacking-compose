package org.ahivs.jetpacking.app.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.ahivs.jetpacking.app.R

class AnimateContentSizeScreen {

    @Preview
    @Composable
    fun AnimateContentSizeDemo() {
        var expanded by remember { mutableStateOf(false) }

        Column {
            Button(
                onClick = { expanded = !expanded }
            ) {
                Text(text = if (expanded) "SHRINK" else "EXPAND")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .background(Color.LightGray)
                    .animateContentSize()
            ) {
                Text(
                    text = stringResource(
                        R.string.lorem_ipsum
                    ),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(16.dp),
                    maxLines = if (expanded) Int.MAX_VALUE else 2
                )
            }
        }
    }

}