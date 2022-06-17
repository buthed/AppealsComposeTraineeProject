package com.example.appealscomposetraineeproject.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

data class AppealsComposeColors(
    val Gray: Color,
    val Blue: Color,
    val GreenStatus : Color,
    val GrayStatus: Color,
    val YellowStatus: Color,
    val RedStatus: Color,
    val GraySpaces: Color,
    val Background: Color,
    val GrayLabel: Color
)

data class AppealsComposeTypography(
    val heading: TextStyle,
    val columnName: TextStyle,
    val tableText: TextStyle,
    val smallSmallTableText: TextStyle
)

object AppealsComposeTheme {
    val colors: AppealsComposeColors
        @Composable
        get() = LocalAppealsComposeColors.current

    val typography: AppealsComposeTypography
        @Composable
        get() = LocalAppealsComposeTypography.current
}

val LocalAppealsComposeColors = staticCompositionLocalOf { extendedPalette }

val LocalAppealsComposeTypography = staticCompositionLocalOf{ extendedTypography }
