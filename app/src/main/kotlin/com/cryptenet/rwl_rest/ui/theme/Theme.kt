package com.cryptenet.rwl_rest.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = CRAYOLA200,
    primaryVariant = CRAYOLA700,
    onPrimary = WHITE,
    secondary = AMERICAN_ORANGE200,
    secondaryVariant = AMERICAN_ORANGE200,
    onSecondary = WHITE,
)

private val LightColorPalette = lightColors(
    primary = CRAYOLA500,
    primaryVariant = CRAYOLA700,
    onPrimary = CHINESE_BLACK500,
    secondary = AMERICAN_ORANGE200,
    secondaryVariant = AMERICAN_ORANGE500,
    onSecondary = CHINESE_BLACK500,
)

@Composable
fun RealWorldTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
