package com.ibrahimethemsen.pigeon.investment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ibrahimethemsen.pigeon.model.FundUI
import com.ibrahimethemsen.pigeon.model.InvestmentCard
import com.ibrahimethemsen.pigeon.ui.sizing.LocalDimensionSizing

@Composable
fun Modifier.investmentLazyColumn() = fillMaxWidth()
    .requiredHeightIn(
        LocalDimensionSizing.current.scale56,
        LocalDimensionSizing.current.scale192
    )

@Composable
fun InvestmentFundCard(
    investmentCard: InvestmentCard,
    fundList: List<FundUI>
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
            items(fundList) {
                InvestmentFundComponent(
                    name = it.name,
                    icon = it.icon,
                    totalValue = it.totalValue,
                    change = it.change,
                    isIncreased = it.isIncreased,
                    valueData = it.valueData
                )
            }
        }
    }
}

@Composable
fun InvestmentFundComponent(
    name: String,
    icon: Char,
    totalValue: String,
    change: String,
    isIncreased: Boolean,
    valueData: Boolean = false
) {
    InvestmentItem(
        name,
        icon,
        totalValue,
        change = change,
        isIncreased = isIncreased
    ) {
        if (valueData) {
            Text(text = "Valör")
        }
    }
}