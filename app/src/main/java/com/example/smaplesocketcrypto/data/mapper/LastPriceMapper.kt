package com.example.smaplesocketcrypto.data.mapper

import com.example.smaplesocketcrypto.data.model.LastPriceEntity
import com.example.smaplesocketcrypto.domain.model.ExampleModels
import javax.inject.Inject

open class LastPriceMapper @Inject constructor() : Mapper<LastPriceEntity, ExampleModels.LastPriceModel> {

    override fun mapFromEntity(type: LastPriceEntity): ExampleModels.LastPriceModel {
        return ExampleModels.LastPriceModel(type.c)
    }

    override fun mapToEntity(type: ExampleModels.LastPriceModel): LastPriceEntity {
        return LastPriceEntity(type.c)
    }
}