package org.ahivs.jetpacking.app.deputy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import org.ahivs.jetpacking.app.theme.MyApplicationTheme

class ApproveScreenActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                ApproveMultipleTimesheetScreen()
            }
        }
    }
}