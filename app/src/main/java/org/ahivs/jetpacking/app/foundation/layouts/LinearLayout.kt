package org.ahivs.jetpacking.app.foundation.layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LinearLayout {

    @Composable
    fun RowDefault() {
        Row {
            RowContent()
        }
    }

    @Composable
    fun RowSpacing() {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RowContent()
        }
    }


    @Composable
    fun SurfaceTest() {
        Surface(
            modifier = Modifier.size(300.dp),
            color = Color.LightGray,
            contentColor = Color.Green,
            elevation = 1.dp,
            border = BorderStroke(1.dp, Color.Black)
        ) {
            RowSpacing()
        }
    }

    @Composable
    fun RowContent() {
        Button(onClick = { }) {
            Text(text = "Button1")
        }
        Button(onClick = { }) {
            Text(text = "Button2")
        }
        Button(onClick = { }) {
            Text(text = "Button3")
        }
    }


    @Preview
    @Composable
    fun Preview() {
        SurfaceTest()
    }
}