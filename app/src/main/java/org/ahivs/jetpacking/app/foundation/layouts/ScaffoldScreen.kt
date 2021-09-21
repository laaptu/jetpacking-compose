package org.ahivs.jetpacking.app.foundation.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.ahivs.jetpacking.app.theme.Purple200

class ScaffoldScreen {

    @Composable
    fun MyScaffold() {
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            scaffoldState = scaffoldState,
            contentColor = Color.Green,
            content = { MyRow() },
            topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = coroutineScope) },
            bottomBar = { MyBottomAppBar() },
            drawerContent = { MyColumn() }
        )


    }

    @Composable
    fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
        val drawerState = scaffoldState.drawerState
        TopAppBar(
            navigationIcon = {IconButton(
                content = {
                    Icon(
                        Icons.Default.Menu,
                        tint = Color.White,
                        contentDescription = "This is drawerIcon"
                    )
                },
                onClick = {
                    scope.launch {
                        if (drawerState.isClosed)
                            drawerState.open()
                        else
                            drawerState.close()
                    }
                }
            )},
            title = {
                Text(
                    text = "Scaffolding App",
                    color = Color.White
                )
            },
            backgroundColor = Purple200
        )
    }

    @Composable
    fun MyBottomAppBar() {

    }

    @Composable
    fun MyColumn() {
        Column(modifier = Modifier.fillMaxHeight()) {
            Text("Item1")
            Text("Item2")
            Text("Item3")
            Text("Item4")
        }
    }

    @Composable
    fun MyRow() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "This is all I have"
            )
        }
    }


    @Preview
    @Composable
    fun MyPreview() {
        MyScaffold()
    }
}