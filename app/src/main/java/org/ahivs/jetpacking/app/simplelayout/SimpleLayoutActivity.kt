package org.ahivs.jetpacking.app.simplelayout

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ahivs.jetpacking.app.theme.MyApplicationTheme
import org.ahivs.jetpacking.app.theme.Teal200

class SimpleLayoutActivity : AppCompatActivity() {


    @Composable
    fun PhotographCard() {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .clip(RoundedCornerShape(12.dp))
                .background(Teal200)
                .clickable { }
                .padding(8.dp)
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {

            }

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text("Alfred Sisley", fontWeight = FontWeight.Bold)
                // LocalContentAlpha is defining opacity level of its children
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text("3 minutes ago", style = MaterialTheme.typography.body2)
                }
            }
        }
    }

    @Preview
    @Composable
    fun PhotographCardPreview() {
        MyApplicationTheme {
            PhotographCard()
        }
    }
}