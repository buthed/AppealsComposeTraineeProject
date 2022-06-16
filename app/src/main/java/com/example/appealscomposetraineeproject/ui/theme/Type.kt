package com.example.appealscomposetraineeproject.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val extendedTypography = AppealsComposeTypography(
    heading = TextStyle(fontSize =  18.sp),
    body = TextStyle(fontSize = 14.sp),
    caption = TextStyle(fontSize = 12.sp),
    smallCaption = TextStyle(fontSize = 10.sp)
)
