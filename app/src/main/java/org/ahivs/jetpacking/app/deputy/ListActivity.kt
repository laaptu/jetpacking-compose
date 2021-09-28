package org.ahivs.jetpacking.app.deputy

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.core.view.WindowCompat
import org.ahivs.jetpacking.app.theme.MyApplicationTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainContent() {
                    startActivity(Intent(this, ApproveScreenActivity::class.java))
                }
            }

        }
    }

    @Composable
    fun MainContent(onClick: () -> Unit) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Green, shape = RectangleShape)
        ) {
            Button(onClick = { onClick() }) {
                Text("Go to next activity")
            }
        }
    }
}