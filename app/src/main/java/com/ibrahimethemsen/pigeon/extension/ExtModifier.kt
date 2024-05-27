package com.ibrahimethemsen.pigeon.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.circleLayout() =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        val currentHeight = placeable.height
        val currentWidth = placeable.width
        val newDiameter = maxOf(currentHeight, currentWidth)

        layout(newDiameter, newDiameter) {
            placeable.placeRelative((newDiameter-currentWidth)/2, (newDiameter-currentHeight)/2)
        }
    }