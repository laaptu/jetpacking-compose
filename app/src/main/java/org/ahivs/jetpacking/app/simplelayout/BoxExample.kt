package org.ahivs.jetpacking.app.simplelayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun BoxExample() {
    Column {
        Text(
            "ActionBar", modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)) {
            Text("This text is drawn first", modifier = Modifier.fillMaxWidth().fillMaxHeight())
//            Box(
//                Modifier
//                    .align(Alignment.TopCenter)
//                    .fillMaxHeight()
//                    .width(
//                        50.dp
//                    )
//                    .background(Color.Blue)
//            )
            Text("This text is drawn last", modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth())
//            FloatingActionButton(
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .padding(12.dp),
//                onClick = {}
//            ) {
//                Text("+")
//            }
        }
    }

}