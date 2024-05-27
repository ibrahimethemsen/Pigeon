package com.ibrahimethemsen.pigeon.investment

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun InvestmentTitleComponent(
    title: String,
    totalValue: String,
    change: String,
    isIncreased: Boolean,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            fontWeight = FontWeight.Bold
        )
        InvestmentPriceComponent(totalValue, change, isIncreased)
    }
}