package org.ahivs.jetpacking.app.data

data class ChatMessage(
    val name: String,
    val time: String,
    val imageUrl: String = "https://developer.android.com/images/brand/Android_Robot.png"
)