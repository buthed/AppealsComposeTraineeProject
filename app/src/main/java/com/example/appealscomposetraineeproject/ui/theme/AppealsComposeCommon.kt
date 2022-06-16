package com.example.appealscomposetraineeproject.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Immutable
data class AppealsComposeColors(
    val Gray: Color,
    val Blue: Color,
    val GreenStatus : Color,
    val GrayStatus: Color,
    val YellowStatus: Color,
    val RedStatus: Color,
    val GraySpaces: Color,
    val Background: Color
)

data class AppealsComposeTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle
)

object AppealsComposeTheme {
    val colors: AppealsComposeColors
        @Composable
        get() = LocalAppealsComposeColors.current

    val typography: AppealsComposeTypography
        @Composable
        get() = LocalAppealsComposeTypography.current
}

enum class AppealsComposeSize {
    Small, Medium, Big
}

val LocalAppealsComposeColors = staticCompositionLocalOf<AppealsComposeColors> {
    AppealsComposeColors(
        Gray = Color(0xFFE6E6E6),
        Blue = Color(0xFF2D69A6),
        GreenStatus = Color(0xFF25AF3B),
        GrayStatus = Color(0xFFA6ABA7),
        YellowStatus = Color(0xFFF3C05B),
        RedStatus = Color(0xFFFF0000),
        GraySpaces = Color(0xFFE5E5E5),
        Background = Color(0xFFFFFFFF) ,
    )
}


val LocalAppealsComposeTypography = staticCompositionLocalOf<AppealsComposeTypography> {
    error("No font provided")
}
