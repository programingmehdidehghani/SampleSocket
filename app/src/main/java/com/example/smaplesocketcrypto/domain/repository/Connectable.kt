package com.example.smaplesocketcrypto.domain.repository

interface Connectable {

    val isConnected: Boolean
    fun connect()
    fun disconnect()
}