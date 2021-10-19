package org.ahivs.jetpacking.app.deputy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.deputy.android.design.theme.DeputyTheme
import org.ahivs.jetpacking.app.theme.MyApplicationTheme

class ApproveScreenActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val groupedPendingTimeSheets = mutableMapOf<String, PendingTimeSheetGroup>()
        for (i in 0..10) {
            val group = Group("Group$i", i * 100)
            val pendingTimeSheets = mutableListOf<PendingTimeSheet>()
            for (j in 0..10) {
                val pendingTimeSheet =
                    PendingTimeSheet("Pending timesheet $i", "Living at ${i * 10}")
                pendingTimeSheets.add(pendingTimeSheet)
            }
            val pendingTimeSheetGroup = PendingTimeSheetGroup(group, pendingTimeSheets)
            groupedPendingTimeSheets["key$i"] = pendingTimeSheetGroup
        }
        setContent {
            var showProgress by remember {
                mutableStateOf(UIProgress.Hide)
            }
            ApproveMultipleTimesheetScreen(
                groups = groupedPendingTimeSheets,
                onCancelClick = {
                    if (showProgress == UIProgress.Hide)
                        showProgress = UIProgress.Show
                    else
                        showProgress = UIProgress.Hide

                },
                uiProgress = showProgress
            )
        }
    }
}