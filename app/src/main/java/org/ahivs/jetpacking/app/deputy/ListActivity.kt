package org.ahivs.jetpacking.app.deputy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
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
import org.ahivs.jetpacking.app.R
import org.ahivs.jetpacking.app.theme.MyApplicationTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainContent() {
                    startActivity(Intent(this, ApproveScreenActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down)
                    //showToast()
                }
            }

        }
    }

    class Toast1(val msgId: Int, vararg val args: Any = emptyArray())

    private fun showToast() {
        val toast = Toast1(
            msgId = R.string.pending_timesheets_partial_approved,
            args = arrayOf(1, 2)
        )
        val string =
            if (toast.args.isEmpty())
                getString(R.string.cdr_approve)
            else
                getString(toast.msgId, *toast.args)
        Toast.makeText(this, string, LENGTH_LONG).show()
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