package com.deputy.android.design.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
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
private fun ButtonNoElevation() = ButtonDefaults.elevation(
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

@SuppressWarnings("LongParameterList")
@Composable
fun DeputyLoadingButton(
    modifier: Modifier = Modifier,
    height: Dp = getLoadingButtonMinHeight(),
    buttonText: String,
    onClickLabel: String? = null,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = DeputyTheme.colors.ButtonPrimaryBackground,
        disabledBackgroundColor = DeputyTheme.colors.ButtonPrimaryBackground
    ),
    progressColor: Color = Color.White,
    showProgress: Boolean = false,
    buttonClick: () -> Unit = {}
) {

    val baseModifier = modifier.height(max(height, getLoadingButtonMinHeight()))

    LoadingButtonBase(
        modifier = baseModifier,
        colors = buttonColors,
        onClick = buttonClick,
        onClickLabel = onClickLabel,
        enabled = !showProgress
    ) {
        if (showProgress) {
            DeputyCircularProgressIndicator(
                color = progressColor,
                modifier = Modifier.size(height - 16.dp)
            )
        } else {
            Text(
                text = buttonText,
                modifier = Modifier.padding(6.dp),
                style = DeputyTheme.typography.callout,
                color = DeputyTheme.colors.ButtonPrimaryLabel
            )
        }
    }
}

@SuppressWarnings("LongParameterList")
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun LoadingButtonBase(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onClickLabel: String? = null,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    content: @Composable RowScope.() -> Unit
) {
    val contentColor by colors.contentColor(enabled)
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = colors.backgroundColor(enabled).value,
        contentColor = contentColor.copy(alpha = 1f),
        elevation = 0.dp,
        onClick = onClick,
        onClickLabel = onClickLabel,
        enabled = enabled,
        role = Role.Button,
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple()
    ) {
        Row(
            modifier
                .defaultMinSize(minWidth = ButtonDefaults.MinWidth)
                .padding(ButtonDefaults.ContentPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}

private fun getLoadingButtonMinHeight() =
    ButtonDefaults.MinHeight +
        ButtonDefaults.ContentPadding.calculateTopPadding() +
        ButtonDefaults.ContentPadding.calculateBottomPadding() - 3.dp

@Preview
@Composable
fun PreviewDeputyLoadingButton() {
    DeputyTheme {
        var showProgress by remember { mutableStateOf(true) }
        DeputyLoadingButton(
            buttonText = "DeputyLoadingButton",
            buttonClick = { showProgress = !showProgress }
        )
    }
}
