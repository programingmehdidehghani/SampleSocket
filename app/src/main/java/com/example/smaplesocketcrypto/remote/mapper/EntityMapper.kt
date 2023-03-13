package com.example.smaplesocketcrypto.remote.mapper

interface EntityMapper<in M, out E> {

    fun mapFromRemote(model: M): E

}