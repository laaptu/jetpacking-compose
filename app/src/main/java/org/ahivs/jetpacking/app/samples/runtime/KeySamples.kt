package org.ahivs.jetpacking.app.samples.runtime

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key


@Composable
fun LocallyUniqueKeys() {
    for (user in users) {
        key(user.id) { UserPreview(user = user) }
    }

    for (user in users.filter { isAdmin }) {
        key(user.id) { Friend(friend = user) }
    }
}


@Composable
fun NotAlwaysUniqueKeys() {
    for ((child, parent) in relationships) {
        key(parent.id) {
            User(user = child)
            User(user = parent)
        }
    }
}


@Composable
fun MoreCorrectUniqueKeys() {
    for ((child, parent) in relationships) {
        key(parent.id to child.id) {
            User(user = child)
            User(user = parent)
        }
    }
}

@Composable private fun User(user: User) {}

@Composable private fun UserPreview(user: User) {}

@Composable private fun Friend(friend: User) {}

private const val isAdmin = true

private val users = listOf<User>()
private val relationships = mapOf<User, User>()