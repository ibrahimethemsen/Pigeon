package com.ibrahimethemsen.models

import kotlinx.serialization.Serializable

@Serializable
data class Currency(
    val price : Int,
    val type : CurrencyType
)