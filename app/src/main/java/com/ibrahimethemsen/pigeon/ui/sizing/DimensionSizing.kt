package com.ibrahimethemsen.pigeon.ui.sizing

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class DimensionSizing internal constructor(
    val scale2: Dp = 2.dp,
    val scale4: Dp = 4.dp,
    val scale6: Dp = 6.dp,
    val scale8: Dp = 8.dp,
    val scale10: Dp = 10.dp,
    val scale12: Dp = 12.dp,
    val scale14: Dp = 14.dp,
    val scale16: Dp = 16.dp,
    val scale18: Dp = 18.dp,
    val scale20: Dp = 20.dp,
    val scale22: Dp = 22.dp,
    val scale24: Dp = 24.dp,
    val scale28: Dp = 28.dp,
    val scale32: Dp = 32.dp,
    val scale36: Dp = 36.dp,
    val scale40: Dp = 40.dp,
    val scale48: Dp = 48.dp,
    val scale56: Dp = 56.dp,
    val scale64: Dp = 64.dp,
    val scale96: Dp = 96.dp,
    val scale128: Dp = 128.dp,
    val scale192: Dp = 192.dp,
)

private val defaultDimensionSizing = DimensionSizing()

val LocalDimensionSizing = staticCompositionLocalOf { defaultDimensionSizing }