package com.ibrahimethemsen.models

import kotlinx.serialization.Serializable

@Serializable
data class Fund(
    val name : String,
    val icon : Char,
    val unitPrice : Double,
    val totalFundAmount : Double,
    val change : Double,
    val valueDate : Boolean,
)
