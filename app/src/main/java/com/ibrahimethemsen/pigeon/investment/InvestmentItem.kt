package com.ibrahimethemsen.pigeon.investment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.ibrahimethemsen.pigeon.extension.circleLayout
import com.ibrahimethemsen.pigeon.ui.sizing.LocalDimensionSizing
import com.ibrahimethemsen.pigeon.ui.sizing.LocalScalableSizing
import com.ibrahimethemsen.pigeon.ui.theme.PigeonGreen
import com.ibrahimethemsen.pigeon.ui.theme.PigeonRed

@Composable
fun InvestmentItem(
    investmentName: String,
    investmentIcon: Char,
    totalValue: String,
    change: String,
    isIncreased: Boolean,
    content: @Composable ColumnScope.() -> Unit
) {
    HorizontalDivider()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = LocalDimensionSizing.current.scale8,
                bottom = LocalDimensionSizing.current.scale8
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(LocalDimensionSizing.current.scale12)
    ) {
        Text(
            modifier = Modifier
                .background(Color.Gray, CircleShape)
                .circleLayout()
                .padding(
                    top = LocalDimensionSizing.current.scale8,
                    start = LocalDimensionSizing.current.scale12,
                    end = LocalDimensionSizing.current.scale12,
                    bottom = LocalDimensionSizing.current.scale8
                ),
            text = investmentIcon.toString(),
            textAlign = TextAlign.Center,
            fontSize = LocalScalableSizing.current.scale20
        )
        Column {
            Text(text = investmentName)
            this.content()
        }
        InvestmentPriceComponent(totalValue, change, isIncreased)
    }
}



@Composable
fun RowScope.InvestmentPriceComponent(
    totalValue: String,
    change: String,
    isIncreased: Boolean,
) {
    Column(
        modifier = Modifier.weight(1f),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "₺$totalValue",
            fontSize = LocalScalableSizing.current.scale20,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = change,
            color = if (isIncreased) {
                PigeonRed
            } else PigeonGreen,
            fontSize = LocalScalableSizing.current.scale14
        )
    }
}