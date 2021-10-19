package org.ahivs.jetpacking.app.deputy

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TotalCount(currCount: Int = 0) {
    var count by mutableStateOf(currCount)
    fun isVisible() = count > 0
    fun getTotal() = when {
        count == 0 -> ""
        count > 100 -> "100+"
        else -> count.toString()
    }
}

class PendingTimeSheetGroup(val group: Group, val pendingTimeSheets: List<PendingTimeSheet>)

class PendingTimeSheet(val name: String, val address: String)

class Group(val groupName: String, val groupTotal: Int)


enum class UIProgress {
    Show,
    Hide
}