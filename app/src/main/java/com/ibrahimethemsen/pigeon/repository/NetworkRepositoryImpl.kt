package com.ibrahimethemsen.pigeon.repository

import com.ibrahimethemsen.models.Currency
import com.ibrahimethemsen.pigeon.datasource.NetworkDataSourceImpl
import com.ibrahimethemsen.pigeon.model.InvestmentUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val networkDataSourceImpl: NetworkDataSourceImpl
) : NetworkRepository {
    override fun getCurrency(): Flow<List<Currency>> = flow {
        emit(networkDataSourceImpl.getCurrency())
    }

    override fun getInvestment(): Flow<InvestmentUI> =
        networkDataSourceImpl.investmentEvents.map {
            it.asInvestmentUI()
        }
}
