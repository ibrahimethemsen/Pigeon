package com.ibrahimethemsen.backend

import com.ibrahimethemsen.backend.dummy.currencyData
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.currencyRoute(){
    routing {
        get("/currency") {
            call.respond(
                currencyData
            )
        }
    }
}