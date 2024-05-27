package com.ibrahimethemsen.backend.dummy

import com.ibrahimethemsen.backend.doubleFormat
import com.ibrahimethemsen.backend.randomDouble
import com.ibrahimethemsen.models.Currency
import com.ibrahimethemsen.models.CurrencyType
import com.ibrahimethemsen.models.Fund
import com.ibrahimethemsen.models.InvestmentModel
import com.ibrahimethemsen.models.Stock
import com.ibrahimethemsen.models.TotalBalance
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

const val DOLLAR = 150
const val TURKISH_LIRA = 2000
const val STOCK_SIZE = 4
const val HAWK_PRICE = 50.5
const val SPARROW_PRICE = 50.5
const val WOLF_PRICE = 12.0
const val ANDROID_PRICE = 100.0
const val KOTLIN_PRICE = 200.0

val currencyData = listOf(
    Currency(DOLLAR, CurrencyType.DOLLAR),
    Currency(TURKISH_LIRA, CurrencyType.TURKISH_LIRA),
)

fun Double.sumRandomDouble(): Double {
    return this + randomDouble()
}

val investmentFlow = flow {
    while (true) {
        val hawkPrice = HAWK_PRICE.sumRandomDouble()
        val sparrowPrice = SPARROW_PRICE.sumRandomDouble()
        val wolfPrice = WOLF_PRICE.sumRandomDouble()
        val androidPrice = ANDROID_PRICE.sumRandomDouble()
        val kotlinPrice = KOTLIN_PRICE.sumRandomDouble()
        val stockList = listOf(
            Stock(
                name = "Hawk",
                icon = 'H',
                buyPrice = HAWK_PRICE,
                unitPrice = hawkPrice,
                totalStockAmount = (STOCK_SIZE * hawkPrice).doubleFormat(2),
                change = (hawkPrice - HAWK_PRICE).doubleFormat(2),
                STOCK_SIZE
            ),
            Stock(
                "Sparrow",
                'S',
                buyPrice = SPARROW_PRICE,
                sparrowPrice,
                (STOCK_SIZE * sparrowPrice).doubleFormat(2),
                change = (sparrowPrice - SPARROW_PRICE).doubleFormat(2),
                STOCK_SIZE
            ),
            Stock(
                "Wolf",
                'W',
                WOLF_PRICE,
                wolfPrice,
                totalStockAmount = (STOCK_SIZE * wolfPrice).doubleFormat(2),
                change = (wolfPrice - WOLF_PRICE).doubleFormat(2),
                STOCK_SIZE
            )
        )
        val fundData = listOf(
            Fund(
                "Android",
                'A',
                androidPrice,
                (STOCK_SIZE * androidPrice).doubleFormat(2),
                change = (androidPrice - ANDROID_PRICE).doubleFormat(4),
                true
            ),
            Fund(
                "Kotlin",
                'K',
                kotlinPrice,
                (STOCK_SIZE * kotlinPrice).doubleFormat(2),
                (kotlinPrice - KOTLIN_PRICE).doubleFormat(4),
                false
            ),
        )
        // First buy
        val totalBalance =
            TURKISH_LIRA + (STOCK_SIZE * HAWK_PRICE) + (STOCK_SIZE * sparrowPrice) + (STOCK_SIZE * wolfPrice) + (STOCK_SIZE * ANDROID_PRICE) + (STOCK_SIZE * KOTLIN_PRICE)
        val totalBalanceValue = (stockList.sumOf { it.totalStockAmount } + fundData.sumOf { it.totalFundAmount } + TURKISH_LIRA)
        emit(
            InvestmentModel(
                totalBalance =
                TotalBalance(
                    price =  totalBalanceValue.doubleFormat(2),
                    change = (totalBalanceValue - totalBalance).doubleFormat(2)
                ),
                stockBalance = stockList,
                fundBalance = fundData
            )
        )
        delay(2000)
    }
}
