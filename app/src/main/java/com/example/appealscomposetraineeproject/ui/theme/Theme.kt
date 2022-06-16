package com.example.appealscomposetraineeproject.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MainTheme(
    textSize: AppealsComposeSize = AppealsComposeSize.Medium,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val extendedTypography = AppealsComposeTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                AppealsComposeSize.Small -> 24.sp
                AppealsComposeSize.Medium -> 28.sp
                AppealsComposeSize.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                AppealsComposeSize.Small -> 14.sp
                AppealsComposeSize.Medium -> 16.sp
                AppealsComposeSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                AppealsComposeSize.Small -> 14.sp
                AppealsComposeSize.Medium -> 16.sp
                AppealsComposeSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                AppealsComposeSize.Small -> 10.sp
                AppealsComposeSize.Medium -> 12.sp
                AppealsComposeSize.Big -> 14.sp
            }
        )
    )

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    CompositionLocalProvider(
        LocalAppealsComposeColors provides basePalette,
        LocalAppealsComposeTypography provides extendedTypography,
        content = content
    )
}