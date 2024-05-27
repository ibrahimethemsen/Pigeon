package com.ibrahimethemsen.models

import kotlinx.serialization.Serializable

@Serializable
data class Stock(
    val name : String,
    val icon : Char,
    val buyPrice : Double,
    val unitPrice : Double,
    val totalStockAmount : Double,
    val change : Double,
    val size : Int
)