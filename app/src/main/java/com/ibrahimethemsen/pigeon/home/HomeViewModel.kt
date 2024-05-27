package com.ibrahimethemsen.pigeon.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimethemsen.pigeon.model.InvestmentCard
import com.ibrahimethemsen.pigeon.model.InvestmentUI
import com.ibrahimethemsen.pigeon.model.TotalBalanceUI
import com.ibrahimethemsen.pigeon.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    pigeonRepository: NetworkRepository,
) : ViewModel() {
    val investmentFlow: StateFlow<InvestmentUI> = pigeonRepository.getInvestment().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        InvestmentUI(
            TotalBalanceUI("0.0", "0.0", false),
            InvestmentCard("", "", "", false),
            emptyList(),
            InvestmentCard("", "", "", false),
            emptyList()
        )
    )

    val getCurrency = pigeonRepository.getCurrency().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        emptyList()
    )
}