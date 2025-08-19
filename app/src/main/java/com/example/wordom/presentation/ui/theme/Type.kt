package com.example.wordom.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wordom.R


val redditMonoFamily = FontFamily(
    Font(R.font.redditmono_light, FontWeight.Light),
    Font(R.font.redditmono_regular, FontWeight.Normal),
    Font(R.font.redditmono_medium, FontWeight.Medium),
    Font(R.font.redditmono_bold, FontWeight.Bold),
    Font(R.font.redditmono_extrabold, FontWeight.ExtraBold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = redditMonoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = redditMonoFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    headlineLarge = TextStyle(
        fontFamily = redditMonoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    )
)
