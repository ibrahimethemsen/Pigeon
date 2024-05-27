package com.ibrahimethemsen.pigeon.investment

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ibrahimethemsen.pigeon.R
import com.ibrahimethemsen.pigeon.home.PigeonTitleActionRow
import com.ibrahimethemsen.pigeon.icon.PigeonIconDrawable
import com.ibrahimethemsen.pigeon.model.FundUI
import com.ibrahimethemsen.pigeon.model.InvestmentCard
import com.ibrahimethemsen.pigeon.model.StockUI

@Composable
fun InvestmentsComponent(
    stockInvestmentCard: InvestmentCard,
    stockList: List<StockUI>,
    fundInvestmentUI: InvestmentCard,
    fundList: List<FundUI>,
) {
    Column {
        PigeonTitleActionRow(title = "Yatırımlar", actionTitle = "Toplam Getiri", icon = {
            PigeonIconDrawable(
                icon = R.drawable.ic_switch
            )
        }) {

        }
        InvestmentStockCard(stockInvestmentCard, stockList)
        InvestmentFundCard(fundInvestmentUI, fundList)
    }
}
