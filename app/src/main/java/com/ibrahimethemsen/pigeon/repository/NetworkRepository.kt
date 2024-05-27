package com.ibrahimethemsen.pigeon.repository

import com.ibrahimethemsen.models.Currency
import com.ibrahimethemsen.models.InvestmentModel
import com.ibrahimethemsen.pigeon.model.InvestmentUI
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {
    fun getCurrency(): Flow<List<Currency>>

    fun getInvestment() : Flow<InvestmentUI>
}