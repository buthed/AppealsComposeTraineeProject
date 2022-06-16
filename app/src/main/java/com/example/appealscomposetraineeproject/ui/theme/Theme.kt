package com.example.appealscomposetraineeproject.ui.theme

import android.graphics.fonts.Font
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun MainTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    CompositionLocalProvider(
        LocalAppealsComposeColors provides extendedPalette,
        LocalAppealsComposeTypography provides extendedTypography,
        content = content
    )
}