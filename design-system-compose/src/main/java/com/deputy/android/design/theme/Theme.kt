package com.deputy.android.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val DarkColorPalette = darkColors(
    primary = Dark.TintSecondary,
    primaryVariant = Dark.TintSecondary,
    secondary = Dark.TintAlternativePrimary,
    secondaryVariant = Dark.TintAlternativeSecondary,
    background = Dark.BackgroundPrimary,
    surface = Dark.BackgroundSecondary,
    error = Dark.TextAttentionLabel,
    onPrimary = Dark.ButtonPrimaryLabel,
    onSecondary = Dark.ButtonSecondaryLabel,
    onBackground = Dark.TextPrimaryLabel,
    onSurface = Dark.TextPrimaryLabel,
    onError = Dark.TextAttentionLabel
)

private val LightColorPalette = lightColors(
    primary = Light.TintSecondary,
    primaryVariant = Light.TintSecondary,
    secondary = Light.TintAlternativePrimary,
    secondaryVariant = Light.TintAlternativeSecondary,
    background = Light.BackgroundPrimary,
    surface = Light.BackgroundSecondary,
    error = Light.TextAttentionLabel,
    onPrimary = Light.ButtonPrimaryLabel,
    onSecondary = Light.ButtonSecondaryLabel,
    onBackground = Light.TextPrimaryLabel,
    onSurface = Light.TextPrimaryLabel,
    onError = Light.TextAttentionLabel
)

@Composable
fun DeputyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () ->
    Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val deputyColors = if (darkTheme) Dark else Light
    val icons = "This is a test"

    ProvideDeputyResources(
        colors = deputyColors,
        typography = Type,
        icons = icons
    ) {
        MaterialTheme(
            colors = colors,
            shapes = Shapes,
            content = { content.invoke() }
        )
    }
}

object DeputyTheme {
    val colors: DeputyColors
        @Composable
        get() = LocalDeputyColors.current
    val typography: Type
        @Composable
        get() = LocalDeputyTypography.current
    val icons: String
        @Composable
        get() = LocalDeputyIcons.current
}

@Composable
fun ProvideDeputyResources(
    colors: DeputyColors,
    typography: Type,
    icons: String,
    content: @Composable () ->
    Unit
) {
    CompositionLocalProvider(
        LocalDeputyColors provides colors,
        LocalDeputyTypography provides typography,
        LocalDeputyIcons provides icons,
        content = content
    )
}

private val LocalDeputyColors = staticCompositionLocalOf<DeputyColors> {
    error("No DeputyColors provided")
}

private val LocalDeputyIcons = staticCompositionLocalOf<String> {
    error("No icons provided")
}

private val LocalDeputyTypography = staticCompositionLocalOf<Type> {
    error("No DeputyTypography provided")
}
/*

*/
/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [DeputyTheme.colors].
 *//*

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Green
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)*/
