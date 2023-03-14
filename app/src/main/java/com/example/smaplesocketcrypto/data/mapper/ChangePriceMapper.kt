package com.example.smaplesocketcrypto.data.mapper

import com.example.smaplesocketcrypto.data.model.LastPriceEntity
import com.example.smaplesocketcrypto.data.model.PriceChangePercentEntity
import com.example.smaplesocketcrypto.domain.model.ExampleModels
import javax.inject.Inject

open class ChangePriceMapper @Inject constructor() : Mapper<PriceChangePercentEntity, ExampleModels.ChangePriceModel>{

    override fun mapFromEntity(type: PriceChangePercentEntity): ExampleModels.ChangePriceModel {
        return ExampleModels.ChangePriceModel(type.P)
    }

    override fun mapToEntity(type: ExampleModels.ChangePriceModel): PriceChangePercentEntity {
        return PriceChangePercentEntity(type.P)
    }
}