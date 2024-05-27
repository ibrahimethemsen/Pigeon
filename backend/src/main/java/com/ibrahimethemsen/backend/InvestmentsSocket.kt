package com.ibrahimethemsen.backend

import com.ibrahimethemsen.backend.dummy.investmentFlow
import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import io.ktor.server.websocket.sendSerialized
import io.ktor.server.websocket.webSocket
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun Application.investmentsSocket() {
    routing {
        webSocket("/investments") {
            coroutineScope {
                launch {
                    investmentFlow.collect{
                        sendSerialized(it)
                        delay(1000)
                    }
                }
            }
        }
    }
}