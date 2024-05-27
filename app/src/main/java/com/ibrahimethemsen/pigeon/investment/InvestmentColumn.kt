package com.ibrahimethemsen.pigeon.investment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.ibrahimethemsen.pigeon.ui.sizing.LocalDimensionSizing

@Composable
fun InvestmentColumn(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = LocalDimensionSizing.current.scale8)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(LocalDimensionSizing.current.scale8)
            )
            .background(Color.White)
            .padding(LocalDimensionSizing.current.scale8),
        verticalArrangement = Arrangement.spacedBy(LocalDimensionSizing.current.scale8)
    ) {
        content.invoke()
    }
}