package com.ibrahimethemsen.backend

import io.ktor.network.tls.certificates.buildKeyStore
import io.ktor.network.tls.certificates.saveToFile
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer
import io.ktor.server.engine.sslConnector
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import org.slf4j.LoggerFactory
import java.io.File

fun main() {
    val keyStoreFile = File("build/keystore.jks")
    val keyStore = buildKeyStore {
        certificate("kmpWebSocket") {
            password = "kotlinMultiPlatform"
            domains = listOf("127.0.0.1", "0.0.0.0", "localhost", "10.0.2.2")
        }
    }
    keyStore.saveToFile(keyStoreFile, "pigeon")

    val environment = applicationEngineEnvironment {
        log = LoggerFactory.getLogger("ktor.application")
        connector {
            port = 8080
        }
        sslConnector(
            keyStore = keyStore,
            keyAlias = "kmpWebSocket",
            keyStorePassword = { "pigeon".toCharArray() },
            privateKeyPassword = { "kotlinMultiPlatform".toCharArray() }) {
            port = 8443
            keyStorePath = keyStoreFile
        }
        module(Application::module)
    }
    embeddedServer(Netty, environment).start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    configureSockets()
    currencyRoute()
    investmentsSocket()
}