package com.deputy.android.design.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.deputy.android.design.R

object Type {
    private val roboto = FontFamily(
        listOf(
            Font(resId = R.font.roboto_regular),
            Font(resId = R.font.roboto_thin, weight = FontWeight.W100),
            Font(resId = R.font.roboto_light, weight = FontWeight.W300),
            Font(resId = R.font.roboto_medium, weight = FontWeight.W500),
            Font(resId = R.font.roboto_bold, weight = FontWeight.W700)
        )
    )
    val largeTitle = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W700,
        fontSize = 32.sp
    )
    val title1 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    )
    val title2 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W500,
        fontSize = 18.sp
    )
    val title3 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    )
    val headline = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    )
    val body1 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    )
    val body2 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    )
    val callout = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    )
    val subhead = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    )
    val footnote = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
    val caption1 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
    val caption2 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp
    )
}
