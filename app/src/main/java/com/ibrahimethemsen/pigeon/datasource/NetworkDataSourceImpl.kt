package com.ibrahimethemsen.pigeon.datasource

import com.ibrahimethemsen.models.Currency
import com.ibrahimethemsen.models.InvestmentModel
import com.ibrahimethemsen.pigeon.di.Dispatcher
import com.ibrahimethemsen.pigeon.network.PigeonService
import com.ibrahimethemsen.pigeon.network.PigeonWebSocket
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val pigeonService: PigeonService,
    webSocket: PigeonWebSocket,
    @Dispatcher(Dispatcher.Type.IO) private val dispatcherIO: CoroutineDispatcher
) : NetworkDataSource {
    override suspend fun getCurrency(): List<Currency> {
        return withContext(dispatcherIO) {
            pigeonService.getCurrency()
        }
    }


    override val investmentEvents = webSocket.events
}