package com.ibrahimethemsen.pigeon.icon

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.ibrahimethemsen.pigeon.ui.theme.PigeonBlue

private val pigeonIconColor = PigeonBlue

@Composable
fun PigeonIconVector(
    icon: ImageVector,
    tint: Color = pigeonIconColor,
    cd: String = ""
) {
    Icon(imageVector = icon, contentDescription = cd, tint = tint)
}

@Composable
fun PigeonIconDrawable(
    @DrawableRes icon: Int,
    tint: Color = pigeonIconColor,
    cd: String = ""
) {
    Icon(painter = painterResource(id = icon), contentDescription = cd, tint = tint)
}