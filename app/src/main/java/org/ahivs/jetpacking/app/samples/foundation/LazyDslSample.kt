package org.ahivs.jetpacking.app.samples.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun LazyColumnSample() {
    val itemsList = (0..5).toList()
    val itemsIndexedList = listOf("A", "B", "C")

    LazyColumn {
        items(itemsList) {
            Text("Item is $it")
        }

        item {
            Text("Single item")
        }

        itemsIndexed(itemsIndexedList) { index, item ->
            Text("Item at index $index is $item")
        }
    }
}


@Composable
fun LazyRowSample() {
    val itemsList = (0..5).toList()
    val itemsIndexedList = listOf("A", "B", "C")

    LazyRow {
        items(itemsList) {
            Text("Item is $it")
        }

        item {
            Text("Single item")
        }

        itemsIndexed(itemsIndexedList) { index, item ->
            Text("Item at index $index is $item")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)

@Composable
fun StickyHeaderSample() {
    val sections = listOf("A", "B", "C", "D", "E", "F", "G")

    LazyColumn(reverseLayout = true, contentPadding = PaddingValues(6.dp)) {
        sections.forEach { section ->
            stickyHeader {
                Text(
                    "Section $section",
                    Modifier.fillMaxWidth().background(Color.LightGray).padding(8.dp)
                )
            }
            items(10) {
                Text("Item $it from the section $section")
            }
        }
    }
}