package com.deputy.android.design.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deputy.android.design.theme.DeputyTheme

@Composable
fun DeputyPrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = DeputyTheme.colors.ButtonPrimaryBackground,
            disabledBackgroundColor = DeputyTheme.colors.ButtonPrimaryDisabledBackground
        ),
        elevation = ButtonNoElevation(),
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        onClick = onClick
    ) {
        Text(
            text,
            modifier = Modifier.padding(6.dp),
            style = DeputyTheme.typography.callout,
            color = if (enabled) DeputyTheme.colors.ButtonPrimaryLabel else DeputyTheme.colors.ButtonPrimaryDisabledLabel
        )
    }
}

@Preview
@Composable
fun PreviewDeputyPrimaryButton() {
    DeputyTheme {
        DeputyPrimaryButton(text = "DeputyPrimaryButton") {}
    }
}

@Composable
fun DeputySecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = DeputyTheme.colors.ButtonSecondaryBackground,
            disabledBackgroundColor = DeputyTheme.colors.ButtonSecondaryDisabledBackground
        ),
        elevation = ButtonNoElevation(),
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        onClick = onClick
    ) {
        Text(
            text,
            modifier = Modifier.padding(6.dp),
            style = DeputyTheme.typography.callout,
            color = if (enabled) DeputyTheme.colors.ButtonSecondaryLabel else DeputyTheme.colors.ButtonSecondaryDisabledLabel
        )
    }
}

@Composable
fun ButtonNoElevation() = ButtonDefaults.elevation(
    defaultElevation = 0.dp,
    pressedElevation = 0.dp,
    disabledElevation = 0.dp
)

@Preview
@Composable
fun PreviewDeputySecondaryButton() {
    DeputyTheme {
        DeputySecondaryButton(text = "DeputySecondaryButton") {}
    }
}

@Composable
fun DeputyTertiaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    TextButton(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick
    ) {
        Text(
            text,
            modifier = Modifier.padding(6.dp),
            style = DeputyTheme.typography.callout,
            // TODO [mkpazon] disabled text to confirm
            color = if (enabled) DeputyTheme.colors.ButtonSecondaryLabel else DeputyTheme.colors.TextTertiaryLabel
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDeputyTertiaryButton() {
    DeputyTheme {
        DeputyTertiaryButton(text = "DeputyTertiaryButton") {}
    }
}

@Composable
fun DeputyFloatingActionButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        modifier = modifier.padding(8.dp),
        backgroundColor = DeputyTheme.colors.TintSecondary,
        onClick = onClick
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = DeputyTheme.colors.ButtonPrimaryLabel
        )
    }
}

@Composable
fun DeputyFloatingActionButton(
    modifier: Modifier = Modifier,
    @DrawableRes drawableRes: Int,
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        modifier = modifier.padding(8.dp),
        onClick = onClick,
        backgroundColor = DeputyTheme.colors.TintSecondary
    ) {
        Icon(
            painterResource(id = drawableRes),
            contentDescription = null,
            tint = DeputyTheme.colors.ButtonPrimaryLabel
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDeputyFloatingActionButton() {
    DeputyTheme {
        DeputyFloatingActionButton(imageVector = Icons.Default.Add) {}
    }
}
