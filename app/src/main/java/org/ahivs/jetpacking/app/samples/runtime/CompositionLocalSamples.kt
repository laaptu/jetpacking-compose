package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf



fun createCompositionLocal() {
    val ActiveUser = compositionLocalOf<User> { error("No active user found!") }
}


fun compositionLocalProvider() {
    @Composable
    fun App(user: User) {
        CompositionLocalProvider(ActiveUser provides user) {
            SomeScreen()
        }
    }
}


fun someScreenSample() {
    @Composable
    fun SomeScreen() {
        UserPhoto()
    }
}


fun consumeCompositionLocal() {
    @Composable
    fun UserPhoto() {
        val user = ActiveUser.current
        ProfileIcon(src = user.profilePhotoUrl)
    }
}

@Suppress("CompositionLocalNaming")
private val ActiveUser = compositionLocalOf<User> { error("No active user found!") }

@Composable
private fun SomeScreen() {
}

@Composable
private fun UserPhoto() {
}
