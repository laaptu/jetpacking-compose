package org.ahivs.jetpacking.app.deputy

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TotalCount {
    var count by mutableStateOf(0)
    fun isVisible() = count > 0
    fun getTotal() = when{
            count == 0 -> ""
            count > 100 -> "100+"
            else -> count.toString()
    }
}