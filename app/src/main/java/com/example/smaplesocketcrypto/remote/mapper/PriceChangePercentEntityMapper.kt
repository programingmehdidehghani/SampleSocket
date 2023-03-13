package com.example.smaplesocketcrypto.remote.mapper

import com.example.smaplesocketcrypto.data.data.PriceChangePercentEntity
import com.example.smaplesocketcrypto.data.data.SymbolEntity
import com.example.smaplesocketcrypto.remote.model.PriceChangePercent
import javax.inject.Inject


open class PriceChangePercentEntityMapper @Inject constructor() : EntityMapper<PriceChangePercent,PriceChangePercentEntity> {
    override fun mapFromRemote(model: PriceChangePercent): PriceChangePercentEntity {
        return PriceChangePercentEntity(model.P)
    }
}