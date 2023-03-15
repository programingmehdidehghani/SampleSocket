package com.example.smaplesocketcrypto.socketManager.mapper

import com.example.smaplesocketcrypto.data.model.LastPriceEntity
import com.example.smaplesocketcrypto.socketManager.model.LastPrice
import javax.inject.Inject


open class LastPriceEntityMapper @Inject constructor() : EntityMapper<LastPrice,LastPriceEntity> {

    override fun mapFromRemote(model: LastPrice): LastPriceEntity {
        return LastPriceEntity(model.c)
    }
}