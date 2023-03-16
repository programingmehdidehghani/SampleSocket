package com.example.smaplesocketcrypto.data

import com.example.smaplesocketcrypto.data.mapper.ChangePriceMapper
import com.example.smaplesocketcrypto.data.mapper.LastPriceMapper
import com.example.smaplesocketcrypto.data.mapper.SymbolMapper
import com.example.smaplesocketcrypto.data.repository.ExampleConnectable
import com.example.smaplesocketcrypto.domain.model.ExampleModels
import com.example.smaplesocketcrypto.domain.repository.ExampleRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ExampleDataRepository @Inject constructor(
    override val connectable: ExampleConnectable,
    private val symbolMapper : SymbolMapper,
    private val lastPriceMapper: LastPriceMapper,
    private val changePriceMapper: ChangePriceMapper
) : ExampleRepository {


    override fun getSymbolModel(): Observable<ExampleModels.SymbolModel> = connectable.getSymbolEntity()
        .map { symbolMapper.mapFromEntity(it) }

    override fun getLastPriceModel(): Observable<ExampleModels.LastPriceModel> = connectable.getLastPriceEntity()
        .map { lastPriceMapper.mapFromEntity(it) }


    override fun getChangePriceModel(): Observable<ExampleModels.ChangePriceModel> = connectable.getPriceChangePercentEntity()
        .map { changePriceMapper.mapFromEntity(it) }

    override fun requestSymbolModel(): Completable = connectable.requestSymbolEntity()

    override fun requestLastPriceModel(): Completable = connectable.requestLastPriceEntity()

    override fun requestChangePriceModel(): Completable = connectable.requestPriceChangePercentEntity()
}