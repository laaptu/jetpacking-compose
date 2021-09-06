package org.ahivs.jetpacking.app.simplelayout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ahivs.jetpacking.app.theme.MyApplicationTheme

class ScaffoldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContentLayout()
        }
    }

    @Composable
    fun ContentLayout() {
        MyApplicationTheme {
            Scaffold(
                topBar = { ToolBar() },
                bottomBar = { BottomBar() }
            ) { padding ->
                BodyContent(
                    Modifier
                        .padding(padding)
                        .padding(9.dp)
                )
            }
        }
    }

    @Composable
    fun ToolBar() {
        TopAppBar(
            title = {
                Text(text = "Scaffold Layout")
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            }
        )
    }

    @Composable
    fun BodyContent(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            Text(text = "Hi There")
            Text(text = "Learning about Scaffold is definitely fun out here")
        }
    }


    @Composable
    fun BottomBar() {
        BottomNavigation {
            BottomView(text = "People", image = Icons.Filled.People)
            BottomView(text = "Book", image = Icons.Filled.Book)
            BottomView(text = "Email", image = Icons.Filled.Email)
            BottomView(text = "Car", image = Icons.Filled.CarRental)
        }
    }

    @Composable
    fun BottomView(text: String, image: ImageVector) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(image, contentDescription = null)
            Text(text = text)
        }
    }

    @Preview
    @Composable
    fun Preview() {
        ContentLayout()
    }
}