package com.ibrahimethemsen.pigeon.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ibrahimethemsen.models.Currency
import com.ibrahimethemsen.pigeon.investment.InvestmentsComponent
import com.ibrahimethemsen.pigeon.model.FundUI
import com.ibrahimethemsen.pigeon.model.InvestmentCard
import com.ibrahimethemsen.pigeon.model.StockUI
import com.ibrahimethemsen.pigeon.model.TotalBalanceUI
import com.ibrahimethemsen.pigeon.trackinglist.TrackingListComponent
import com.ibrahimethemsen.pigeon.ui.sizing.LocalDimensionSizing
import com.ibrahimethemsen.pigeon.ui.theme.PigeonBgGray

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val investmentFlow = homeViewModel.investmentFlow.collectAsStateWithLifecycle()
    val currency = homeViewModel.getCurrency.collectAsStateWithLifecycle()

    HomeScreen(
        totalPrice = investmentFlow.value.totalBalance,
        currency = currency.value,
        stockList = investmentFlow.value.stockList,
        stockInvestmentCard = investmentFlow.value.stockInvestmentCard,
        fundList = investmentFlow.value.fundList,
        fundInvestmentCard = investmentFlow.value.fundInvestmentCard
    )
}

@Composable
fun HomeScreen(
    totalPrice: TotalBalanceUI,
    currency: List<Currency>,
    stockList: List<StockUI>,
    stockInvestmentCard: InvestmentCard,
    fundList: List<FundUI>,
    fundInvestmentCard: InvestmentCard,
) {
    val scrollState = rememberScrollState()
    val overlapHeightPx = with(LocalDensity.current) {
        EXPANDED_TOP_BAR_HEIGHT.toPx() - COLLAPSED_TOP_BAR_HEIGHT.toPx()
    }

    val isCollapsed: Boolean by remember {
        derivedStateOf {
            scrollState.value > overlapHeightPx
        }
    }
    Scaffold(
        topBar = {
            CollapsedTopBar(
                modifier = Modifier.zIndex(2f),
                isCollapsed = isCollapsed,
                price = totalPrice
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PigeonBgGray)
                .verticalScroll(scrollState)
                .padding(
                    top = innerPadding.calculateTopPadding() - LocalDimensionSizing.current.scale4,
                    start = LocalDimensionSizing.current.scale16,
                    end = LocalDimensionSizing.current.scale16
                )
        ) {
            ExpandedTopBar(totalPrice)
            TransactionsRow(transferClick = { }, pullClick = { }) {}
            CurrencyCard(currency)
            InvestmentsComponent(
                stockInvestmentCard,
                stockList,
                fundInvestmentCard,
                fundList
            )
            TrackingListComponent()
        }
    }
}