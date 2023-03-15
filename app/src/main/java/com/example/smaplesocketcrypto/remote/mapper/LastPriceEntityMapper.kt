package com.example.smaplesocketcrypto.remote.mapper

import com.example.smaplesocketcrypto.data.model.LastPriceEntity
import com.example.smaplesocketcrypto.remote.model.LastPrice
import javax.inject.Inject


open class LastPriceEntityMapper @Inject constructor() : EntityMapper<LastPrice,LastPriceEntity> {

    override fun mapFromRemote(model: LastPrice): LastPriceEntity {
        return LastPriceEntity(model.c)
    }
}