package com.example.smaplesocketcrypto.remote

import io.socket.client.Manager
import java.net.URI

object AppSocketServiceFactory {

    private const val baseSocketUrl: String = "https://binance-docs.github.io/apidocs/futures/en/#all-market-Ickers-streams"

    private enum class SocketNameSpace(val value: String) {
        CARD("/cards")
    }

    private val socketManager: Manager by lazy {
        Manager(URI(baseSocketUrl))
    }

    fun exampleSocket() = AppSocket(socketManager.socket(SocketNameSpace.CARD.value))
}