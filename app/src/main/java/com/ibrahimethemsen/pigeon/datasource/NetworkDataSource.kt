package com.ibrahimethemsen.pigeon.datasource

import com.ibrahimethemsen.models.Currency
import com.ibrahimethemsen.models.InvestmentModel
import kotlinx.coroutines.flow.Flow

interface NetworkDataSource {
    suspend fun getCurrency() : List<Currency>

    val investmentEvents : Flow<InvestmentModel>
}