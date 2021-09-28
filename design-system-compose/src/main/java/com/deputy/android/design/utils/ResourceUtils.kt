package com.deputy.android.design.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun isTablet(): Boolean = LocalConfiguration.current.screenWidthDp >= 600

inline fun Modifier.clickableWithoutRipple(
    onClickLabel: String? = null,
    crossinline onClick: () -> Unit
): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}