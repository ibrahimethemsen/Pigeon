package com.ibrahimethemsen.pigeon.network

import com.ibrahimethemsen.models.InvestmentModel
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import javax.inject.Inject

class PigeonWebSocket @Inject constructor(
    private val okHttpClient : OkHttpClient,
    private val request : Request
) {
    private lateinit var socket : WebSocket

    val events : Flow<InvestmentModel> = callbackFlow {
        val listener = webSocketListener()
        socket = okHttpClient.newWebSocket(request,listener)
        awaitClose{
            socket.cancel()
        }
    }

    private fun ProducerScope<InvestmentModel>.webSocketListener() : WebSocketListener{
        return object : WebSocketListener(){
            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                println("open")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                val a = Json.decodeFromString<InvestmentModel>(text)
                trySendBlocking(a)
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                println("closing")
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosed(webSocket, code, reason)
                println("closed")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                println("failure")
            }
        }
    }
}