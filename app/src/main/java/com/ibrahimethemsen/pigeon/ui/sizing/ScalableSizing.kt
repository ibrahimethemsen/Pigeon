package com.ibrahimethemsen.pigeon.ui.sizing

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import javax.annotation.concurrent.Immutable

@Immutable
data class ScalableSizing internal constructor(
    val scale12 : TextUnit = 12.sp,
    val scale16 : TextUnit = 16.sp,
    val scale14 : TextUnit = 14.sp,
    val scale20 : TextUnit = 20.sp,
    val scale24 : TextUnit = 24.sp,
    val scale28 : TextUnit = 28.sp,
    val scale32 : TextUnit = 32.sp,
    val scale36 : TextUnit = 36.sp,
)

private val defaultScalableSizing = ScalableSizing()

val LocalScalableSizing = staticCompositionLocalOf { defaultScalableSizing }

