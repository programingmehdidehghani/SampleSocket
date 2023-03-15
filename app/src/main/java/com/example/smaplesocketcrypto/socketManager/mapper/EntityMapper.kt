package com.example.smaplesocketcrypto.socketManager.mapper

interface EntityMapper<in M, out E> {

    fun mapFromRemote(model: M): E

}