package com.deputy.android.design.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.deputy.android.design.theme.DeputyTheme

@Composable
fun DeputyBlueLoadingButton(
    buttonModifier: Modifier = Modifier,
    height: Dp = getMinHeight(),
    buttonText: String = "",
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = DeputyTheme.colors.ButtonPrimaryBackground,
        disabledBackgroundColor = DeputyTheme.colors.ButtonPrimaryBackground
    ),
    progressColor: Color = Color.White,
    showProgress: Boolean = false,
    buttonClick: () -> Unit = {}
) {

    val baseModifier = buttonModifier.defaultMinSize(minHeight = height)

    ButtonBase(
        modifier = baseModifier,
        height = height,
        colors = buttonColors,
        onClick = buttonClick,
        enabled = !showProgress
    ) {
        if (showProgress) {
            CircularProgressIndicator(
                color = progressColor,
                modifier = Modifier.size(height - 16.dp)
            )
        } else {
            Text(
                buttonText,
                modifier = Modifier.padding(6.dp),
                style = DeputyTheme.typography.callout,
                color = DeputyTheme.colors.ButtonPrimaryLabel
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonBase(
    onClick: () -> Unit,
    height: Dp,
    modifier: Modifier = Modifier,
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
        enabled = enabled,
        role = Role.Button,
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple()
    ) {
        CompositionLocalProvider(LocalContentAlpha provides contentColor.alpha) {
            ProvideTextStyle(
                value = MaterialTheme.typography.button
            ) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = ButtonDefaults.MinWidth,
                        )
                        .height(height)
                        .padding(ButtonDefaults.ContentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}

private fun getMinHeight() =
    ButtonDefaults.MinHeight +
            ButtonDefaults.ContentPadding.calculateTopPadding() + ButtonDefaults.ContentPadding.calculateBottomPadding() - 3.dp

