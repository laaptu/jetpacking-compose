package org.ahivs.jetpacking.app.simplelayout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch
import org.ahivs.jetpacking.app.data.ChatMessage
import org.ahivs.jetpacking.app.theme.MyApplicationTheme
import org.ahivs.jetpacking.app.theme.Teal200
import org.w3c.dom.Text

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleList()
        }
    }


    @Composable
    fun SimpleList() {
        MyApplicationTheme {
            RecyclerView(contents = getChatMessages())
        }
    }


    @Composable
    fun RecyclerView(contents: List<ChatMessage>) {
        val scrollState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White),

            ) {

            LazyColumn(
                modifier = Modifier.weight(1f),
                state = scrollState
            ) {
                items(contents) {
                    PhotographCard(chatMessage = it)
                }
            }

            Row() {
                Button(modifier = Modifier.weight(0.5f),
                    onClick = {
                        coroutineScope.launch {
                            scrollState.animateScrollToItem(0)
                        }
                    }) {
                    Text("Scroll To Top")
                }
                Button(modifier = Modifier.weight(0.5f),
                    onClick = {
                        coroutineScope.launch {
                            scrollState.animateScrollToItem(contents.size - 1)
                        }
                    }) {
                    Text("Scroll To End")
                }
            }
        }

    }

    @Composable
    fun PhotographCard(chatMessage: ChatMessage) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .clip(RoundedCornerShape(12.dp))
                .background(Teal200)
                .clickable { }
                .padding(8.dp)
        ) {
            Image(
                painter = rememberImagePainter(data = chatMessage.imageUrl),
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(chatMessage.name, fontWeight = FontWeight.Bold)
                // LocalContentAlpha is defining opacity level of its children
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text("${chatMessage.time} minutes ago", style = MaterialTheme.typography.body2)
                }
            }
        }
    }


    @Composable
    fun ScrollView() {
        val scrollState = rememberScrollState()
        Column(Modifier.verticalScroll(scrollState)) {
            repeat(100) {
                Text(text = "Item $it")
            }
        }
    }

    private fun getItems(): List<String> {
        return (1..100).map { it.toString() }
    }

    private fun getChatMessages(): List<ChatMessage> {
        return (1..100).map {
            ChatMessage(name = "Author $it", time = "$it")
        }
    }


    @Preview
    @Composable
    fun PreviewList() {
        SimpleList()
    }
}