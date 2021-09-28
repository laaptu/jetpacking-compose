package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.runtime.Composable

@Composable
internal fun ProfileIcon(src: String) {}

internal class User {
    val id = 0
    val name = ""
    val profilePhotoUrl = ""
}

internal object Api {
    fun login(username: String, password: String) {}
    fun getUserAsync(id: Int, user: (User) -> Unit): () -> Unit = {}
}