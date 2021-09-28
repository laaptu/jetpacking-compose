package com.deputy.android.design.components

import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.deputy.android.design.theme.DeputyTheme

@Composable
fun DeputyLinearProgressIndicator(
    modifier: Modifier = Modifier
) {
    LinearProgressIndicator(
        modifier = modifier,
        color = DeputyTheme.colors.TintAlternativePrimary
    )
}
