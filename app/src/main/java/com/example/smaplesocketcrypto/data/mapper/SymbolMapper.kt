package com.example.smaplesocketcrypto.data.mapper

import com.example.smaplesocketcrypto.data.model.SymbolEntity
import com.example.smaplesocketcrypto.domain.model.ExampleModels
import javax.inject.Inject


open class SymbolMapper @Inject constructor() : Mapper<SymbolEntity, ExampleModels.SymbolModel>{
    override fun mapFromEntity(type: SymbolEntity): ExampleModels.SymbolModel {
        return ExampleModels.SymbolModel(type.s)
    }

    override fun mapToEntity(type: ExampleModels.SymbolModel): SymbolEntity {
        return SymbolEntity(type.s)
    }
}