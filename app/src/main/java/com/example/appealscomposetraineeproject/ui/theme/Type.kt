package com.example.appealscomposetraineeproject.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.appealscomposetraineeproject.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val extendedFonts = FontFamily(
    Font(R.font.roboto_regular),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_thin, FontWeight.Thin)
)

val extendedTypography = AppealsComposeTypography(
    heading = TextStyle(
        fontSize =  18.sp,
        fontFamily = extendedFonts
    ),
    columnName = TextStyle(
        fontSize = 14.sp,
        fontFamily = extendedFonts,
        fontWeight = FontWeight.Bold
    ),
    tableText = TextStyle(
        fontSize = 12.sp,
        fontFamily = extendedFonts
    ),
    smallSmallTableText = TextStyle(
        fontSize = 10.sp,
        fontFamily = extendedFonts
    )
)
