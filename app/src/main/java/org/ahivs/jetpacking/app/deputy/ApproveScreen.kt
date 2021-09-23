package org.ahivs.jetpacking.app.deputy

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Preview
@Composable
fun ApproveMultipleTimesheetScreen() {
    Card(
        shape = RoundedCornerShape(
            topStart = 14.dp,
            topEnd = 14.dp,
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        ),
    ) {
        Column() {
            TopBar()
            TimesheetList(Modifier.weight(1f))
            BottomView()
        }
    }

}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Text(
        "This is top bar",
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
        color = Color.White
    )
}

@Composable
fun TimesheetList(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("This is timesheet list")
    }
}


@Composable
fun BottomView(modifier: Modifier = Modifier) {
    Text(
        "This is bottom bar",
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
        color = Color.White
    )
}