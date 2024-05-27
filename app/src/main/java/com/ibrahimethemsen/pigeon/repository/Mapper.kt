package com.ibrahimethemsen.pigeon.repository

import com.ibrahimethemsen.models.Fund
import com.ibrahimethemsen.models.InvestmentModel
import com.ibrahimethemsen.models.Stock
import com.ibrahimethemsen.pigeon.extension.changeToString
import com.ibrahimethemsen.pigeon.extension.doubleFormat
import com.ibrahimethemsen.pigeon.extension.isIncreased
import com.ibrahimethemsen.pigeon.extension.sumOfDouble
import com.ibrahimethemsen.pigeon.extension.sumOfPrefix
import com.ibrahimethemsen.pigeon.extension.sumOfString
import com.ibrahimethemsen.pigeon.model.FundUI
import com.ibrahimethemsen.pigeon.model.InvestmentCard
import com.ibrahimethemsen.pigeon.model.InvestmentUI
import com.ibrahimethemsen.pigeon.model.StockUI
import com.ibrahimethemsen.pigeon.model.TotalBalanceUI

fun InvestmentModel.asInvestmentUI() : InvestmentUI{
    return InvestmentUI(
        totalBalance = TotalBalanceUI(
            price = totalBalance.price.doubleFormat(2).toString(),
            change = totalBalance.change.doubleFormat(2).changeToString(),
            isMinus = totalBalance.change.changeToString().startsWith("-")
        ),
        fundInvestmentCard = fundBalance.asInvestmentCard("Borsa İstanbul",{totalFundAmount},{change}),
        fundList = fundBalance.map { it.asFundUI()},
        stockInvestmentCard = stockBalance.asInvestmentCard("Yatırım Fonları",{totalStockAmount},{change}),
        stockList = stockBalance.map { it.asStockUI() }
    )
}

private fun <T> List<T>.asInvestmentCard(
    title : String,
    totalValue : T.() -> Double,
    change : T.() -> Double
) : InvestmentCard {
    return InvestmentCard(
        title = title,
        totalValue = this.sumOfString(totalValue),
        change = this.sumOfPrefix(change),
        isIncreased = this.sumOfDouble(change).isIncreased()
    )
}

private fun Stock.asStockUI() : StockUI {
    return StockUI(
        name,
        icon,
        totalStockAmount.toString(),
        (change * size).changeToString(),
        change.isIncreased(),
        unitPrice.doubleFormat(2).toString()
    )
}

private fun Fund.asFundUI() : FundUI {
    return FundUI(
        name,
        icon,
        totalFundAmount.toString(),
        change.changeToString(),
        change.isIncreased(),
        valueDate
    )
}