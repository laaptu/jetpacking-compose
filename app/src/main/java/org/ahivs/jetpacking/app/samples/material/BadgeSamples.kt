package org.ahivs.jetpacking.app.samples.material

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavigationItemWithBadge() {
    BottomNavigation {
        BottomNavigationItem(
            icon = {
                BadgedBox(badge = { Text("8") }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Favorite"
                    )
                }
            },
            selected = false,
            onClick = {}
        )
    }
}