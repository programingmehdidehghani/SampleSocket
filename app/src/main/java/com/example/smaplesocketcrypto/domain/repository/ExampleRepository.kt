package com.example.smaplesocketcrypto.domain.repository

import com.example.smaplesocketcrypto.domain.model.ExampleModels
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface ExampleRepository {
    val connectable : Connectable

    fun getSymbolModel(): Observable<ExampleModels.SymbolModel>
    fun getLastPriceModel(): Observable<ExampleModels.LastPriceModel>
    fun getChangePriceModel(): Observable<ExampleModels.ChangePriceModel>

    fun requestSymbolModel(): Completable
    fun requestLastPriceModel(): Completable
    fun requestChangePriceModel(): Completable

}