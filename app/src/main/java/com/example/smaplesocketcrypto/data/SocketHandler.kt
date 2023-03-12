package com.example.smaplesocketcrypto.data

import io.socket.client.IO
import java.net.Socket
import java.net.URISyntaxException

object SocketHandler {

    private lateinit var mSocket : io.socket.client.Socket

    @Synchronized
    fun setSocket(){
        try {
            mSocket = IO.socket("wss://fstream.binance.com\n")
        }catch (e : URISyntaxException){
            throw  RuntimeException(e);
        }

    }

    @Synchronized
    fun getSocket(): io.socket.client.Socket {
        return mSocket
    }

    @Synchronized
    fun connect(): io.socket.client.Socket {
        return mSocket.connect()
    }
    @Synchronized
    fun disConnect(): io.socket.client.Socket {
        return mSocket.disconnect()
    }
}
