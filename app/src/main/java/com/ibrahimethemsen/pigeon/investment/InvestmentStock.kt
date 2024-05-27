package com.ibrahimethemsen.pigeon.investment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ibrahimethemsen.pigeon.model.InvestmentCard
import com.ibrahimethemsen.pigeon.model.StockUI
import com.ibrahimethemsen.pigeon.ui.sizing.LocalDimensionSizing


@Composable
fun InvestmentStockCard(
    name: String,
    icon: Char,
    totalValue: String,
    change: String,
    isIncreased: Boolean,
    unitPrice: String,
) {
    InvestmentItem(
        name,
        icon,
        totalValue,
        change = change,
        isIncreased = isIncreased
    ) {
        Text(text = "₺$unitPrice")
    }
}

@Composable
fun InvestmentStockCard(
    investmentCard: InvestmentCard,
    stockList: List<StockUI>
) {
    InvestmentColumn {
        InvestmentTitleComponent(
            title = investmentCard.title,
            totalValue = investmentCard.totalValue,
            change = investmentCard.change,
            isIncreased = investmentCard.isIncreased
        )
        LazyColumn(
            modifier = Modifier.investmentLazyColumn(),
            verticalArrangement = Arrangement.spacedBy(LocalDimensionSizing.current.scale4)
        ) {
            items(stockList) {
                InvestmentStockCard(
                    name = it.name,
                    icon = it.icon,
                    totalValue = it.totalValue,
                    change = it.change,
                    isIncreased = it.isIncreased,
                    unitPrice = it.unitPrice
                )
            }
        }
    }
}