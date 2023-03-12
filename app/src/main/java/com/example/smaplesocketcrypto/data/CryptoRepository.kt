package com.example.smaplesocketcrypto.data

import com.example.smaplesocketcrypto.domain.CryptoRepository
import javax.inject.Inject

class CryptoRepository @Inject constructor(

) : CryptoRepository {

    override fun getSocket() {
       /* SocketHandler.setSocket()
        mSocket = SocketHandler.getSocket()
        mSocket.connect()*/
    }
}