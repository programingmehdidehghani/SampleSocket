package com.example.smaplesocketcrypto.socketManager.mapper

import com.example.smaplesocketcrypto.data.model.PriceChangePercentEntity
import com.example.smaplesocketcrypto.socketManager.model.PriceChangePercent
import javax.inject.Inject


open class PriceChangePercentEntityMapper @Inject constructor() : EntityMapper<PriceChangePercent,PriceChangePercentEntity> {
    override fun mapFromRemote(model: PriceChangePercent): PriceChangePercentEntity {
        return PriceChangePercentEntity(model.P)
    }
}