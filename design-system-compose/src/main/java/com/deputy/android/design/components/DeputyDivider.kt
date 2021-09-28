package com.deputy.android.design.components

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.deputy.android.design.theme.DeputyTheme

@Composable
fun DeputyPrimaryDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
) {
    Divider(
        modifier = modifier,
        color = DeputyTheme.colors.SeparatorPrimary,
        thickness = thickness,
        startIndent = startIndent
    )
}

@Composable
fun DeputySecondaryDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
) {
    Divider(
        modifier = modifier,
        color = DeputyTheme.colors.SeparatorSecondary,
        thickness = thickness,
        startIndent = startIndent
    )
}

@Preview
@Composable
fun DeputyPrimaryDividerPreview() {
    DeputyTheme {
        DeputyPrimaryDivider()
    }
}

@Preview
@Composable
fun DeputySecondaryDividerPreview() {
    DeputyTheme {
        DeputySecondaryDivider()
    }
}
