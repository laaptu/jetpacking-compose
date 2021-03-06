package org.ahivs.jetpacking.app.samples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ClickableListItems() {
    Column {
        var switched by remember { mutableStateOf(false) }
        val onSwitchedChange: (Boolean) -> Unit = { switched = it }
        ListItem(
            text = { Text("Switch ListItem") },
            trailing = {
                Switch(
                    checked = switched,
                    onCheckedChange = null // null recommended for accessibility with screenreaders
                )
            },
            modifier = Modifier.toggleable(
                value = switched,
                onValueChange = onSwitchedChange
            )
        )
        Divider()
        var checked by remember { mutableStateOf(true) }
        val onCheckedChange: (Boolean) -> Unit = { checked = it }
        ListItem(
            text = { Text("Checkbox ListItem") },
            trailing = {
                Checkbox(
                    checked = checked,
                    onCheckedChange = null // null recommended for accessibility with screenreaders
                )
            },
            modifier = Modifier.toggleable(
                value = checked,
                onValueChange = onCheckedChange
            )
        )
        Divider()
    }
}

@Preview
@Composable
@OptIn(ExperimentalMaterialApi::class)
fun OneLineListItems() {
    Column {
        ListItem(text = { Text("One line list item with no icon") })
        Divider()
        ListItem(
            text = { Text("One line list item with 24x24 icon") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("One line list item with 40x40 icon") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("One line list item with 56x56 icon") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("One line clickable list item") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
            },
            modifier = Modifier.clickable { }
        )
        Divider()
        ListItem(
            text = { Text("One line list item with trailing icon") },
            trailing = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized Description"
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("One line list item") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            },
            trailing = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description"
                )
            }
        )
        Divider()
    }
}

@Preview
@Composable
@OptIn(ExperimentalMaterialApi::class)
fun TwoLineListItems() {
    Column {
        ListItem(
            text = { Text("Two line list item") },
            secondaryText = { Text("Secondary text") }
        )
        Divider()
        ListItem(
            text = { Text("Two line list item") },
            overlineText = { Text("OVERLINE") }
        )
        Divider()
        ListItem(
            text = { Text("Two line list item with 24x24 icon") },
            secondaryText = { Text("Secondary text") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("Two line list item with 40x40 icon") },
            secondaryText = { Text("Secondary text") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("Two line list item with 40x40 icon") },
            secondaryText = { Text("Secondary text") },
            trailing = { Text("meta") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        )
        Divider()
    }
}

@Preview
@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ThreeLineListItems() {
    Column {
        ListItem(
            text = { Text("Three line list item") },
            secondaryText = {
                Text(
                    "This is a long secondary text for the current list item, " +
                            "displayed on two lines"
                )
            },
            singleLineSecondaryText = false,
            trailing = { Text("meta") }
        )
        Divider()
        ListItem(
            text = { Text("Three line list item") },
            overlineText = { Text("OVERLINE") },
            secondaryText = { Text("Secondary text") }
        )
        Divider()
        ListItem(
            text = { Text("Three line list item with 24x24 icon") },
            secondaryText = {
                Text(
                    "This is a long secondary text for the current list item " +
                            "displayed on two lines"
                )
            },
            singleLineSecondaryText = false,
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("Three line list item with trailing icon") },
            secondaryText = {
                Text(
                    "This is a long secondary text for the current list" +
                            " item, displayed on two lines"
                )
            },
            singleLineSecondaryText = false,
            trailing = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description"
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("Three line list item") },
            overlineText = { Text("OVERLINE") },
            secondaryText = { Text("Secondary text") },
            trailing = { Text("meta") }
        )
        Divider()
    }
}

// Demos for mixing RTL and LTR ListItems:

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun OneLineRtlLtrListItems() {
    Column {
        ListItem(text = { Text("One line list item with no icon") })
        Divider()
        ListItem(
            text = { Text("???????? ???????????? ?????? ???? ??????????.") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("One line list item with 24x24 icon") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("???????? ?????????? ???????? ???? ?????? ??????????") },
            trailing = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null
                )
            }
        )
        Divider()
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun TwoLineRtlLtrListItems() {
    Column {
        ListItem(
            text = { Text("Two line list item") },
            secondaryText = { Text("Secondary text") }
        )
        Divider()
        ListItem(
            text = { Text("?????? ?????????? ???? ??????????") },
            secondaryText = { Text("???? ??????????") }
        )
        Divider()
        ListItem(
            modifier = Modifier.clickable { },
            text = { Text("Clickable") },
            secondaryText = { Text("Short item") }
        )
        Divider()
        ListItem(
            text = { Text("???????? ?????????? ???????? ???? ?????????? ???? ??????") },
            overlineText = { Text("?????? ????????") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        )
        Divider()
        ListItem(
            text = { Text("?????????? ???????????? ??????????") },
            secondaryText = { Text("???? ??????????") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            },
            modifier = Modifier.clickable { }
        )
        Divider()
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ThreeLineRtlLtrListItems() {
    Column {
        ListItem(
            text = { Text("Three line list item") },
            overlineText = { Text("OVERLINE") },
            secondaryText = { Text("Secondary text") },
            trailing = { Text("meta") }
        )
        Divider()
        ListItem(
            text = { Text("?????????? ?????????? ?????????? ???????? ??????") },
            secondaryText = {
                Text(
                    "?????? ???? ?????????? ???????? ?????????? ?????????????? ???????????? ?? ?????????? ?????? ??????????. " +
                            "???? ???????? ???????? ???? ?????????? ?????? ???????????? ???? ????????"
                )
            },
            singleLineSecondaryText = false
        )
        Divider()
        ListItem(
            text = { Text("?????????? ?????????? ?????????? ???? ??????") },
            overlineText = { Text("?????? ????????") },
            secondaryText = { Text("???? ??????????") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        )
        Divider()
    }
}