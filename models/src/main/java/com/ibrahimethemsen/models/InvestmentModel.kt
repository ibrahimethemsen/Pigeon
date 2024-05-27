package com.ibrahimethemsen.models

import kotlinx.serialization.Serializable

@Serializable
data class InvestmentModel(
    val totalBalance : TotalBalance,
    val stockBalance : List<Stock>,
    val fundBalance : List<Fund>,
)

@Serializable
data class TotalBalance(
    val price : Double,
    val change : Double
)