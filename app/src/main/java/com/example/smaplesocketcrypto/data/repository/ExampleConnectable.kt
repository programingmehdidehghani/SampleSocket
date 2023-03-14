package com.example.smaplesocketcrypto.data.repository

import com.example.smaplesocketcrypto.data.model.LastPriceEntity
import com.example.smaplesocketcrypto.data.model.PriceChangePercentEntity
import com.example.smaplesocketcrypto.data.model.SymbolEntity
import com.example.smaplesocketcrypto.domain.repository.Connectable
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface ExampleConnectable : Connectable {
    fun getSymbolEntity(): Observable<SymbolEntity>
    fun getLastPriceEntity(): Observable<LastPriceEntity>
    fun getPriceChangePercentEntity(): Observable<PriceChangePercentEntity>

    fun requestSymbolEntity(): Completable
    fun requestLastPriceEntity(): Completable
    fun requestPriceChangePercentEntity(): Completable

}