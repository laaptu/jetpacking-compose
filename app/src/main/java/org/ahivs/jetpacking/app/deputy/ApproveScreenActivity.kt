package org.ahivs.jetpacking.app.deputy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import com.deputy.android.design.theme.DeputyTheme
import org.ahivs.jetpacking.app.theme.MyApplicationTheme

class ApproveScreenActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApproveMultipleTimesheetScreen()
        }
    }
}