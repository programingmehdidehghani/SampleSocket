package com.example.smaplesocketcrypto.data.repository

import com.example.smaplesocketcrypto.data.SocketHandler
import com.example.smaplesocketcrypto.domain.CryptoRepository
import javax.inject.Inject

class CryptoRepository @Inject constructor(

) : CryptoRepository {

    override fun getSocket() {
        SocketHandler.setSocket()
        SocketHandler.getSocket()
    }

    override fun connect() {
        SocketHandler.setSocket()
        SocketHandler.connect()
    }

    override fun disConnect() {
        SocketHandler.setSocket()
        SocketHandler.disConnect()
    }
}