package com.ibrahimethemsen.pigeon.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

data class InvestmentUI(
    val totalBalance : TotalBalanceUI,
    val fundInvestmentCard : InvestmentCard,
    val fundList : List<FundUI>,
    val stockInvestmentCard : InvestmentCard,
    val stockList : List<StockUI>
)

data class TotalBalanceUI(
    val price : String,
    val change : String,
    val isMinus : Boolean,
)

data class InvestmentCard(
    val title : String,
    val totalValue : String,
    val change : String,
    val isIncreased : Boolean
)
data class FundUI(
    val name : String,
    val icon : Char,
    val totalValue : String,
    val change : String,
    val isIncreased : Boolean,
    val valueData : Boolean
)

data class StockUI(
    val name: String,
    val icon: Char,
    val totalValue: String,
    val change: String,
    val isIncreased: Boolean,
    val unitPrice: String,
)