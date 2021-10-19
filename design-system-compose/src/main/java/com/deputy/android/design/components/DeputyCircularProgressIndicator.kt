package com.deputy.android.design.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.deputy.android.design.theme.DeputyTheme

@Composable
fun DeputyCircularProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = DeputyTheme.colors.TintAlternativePrimary
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = color
    )
}
