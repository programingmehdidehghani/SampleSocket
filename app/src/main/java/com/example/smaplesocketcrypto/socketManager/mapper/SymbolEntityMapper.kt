package com.example.smaplesocketcrypto.socketManager.mapper

import com.example.smaplesocketcrypto.data.model.SymbolEntity
import com.example.smaplesocketcrypto.socketManager.model.Symbol
import javax.inject.Inject

open class SymbolEntityMapper @Inject constructor() :EntityMapper<Symbol, SymbolEntity> {
    override fun mapFromRemote(model: Symbol): SymbolEntity {
        return SymbolEntity(model.s)
    }
}