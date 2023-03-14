package com.example.smaplesocketcrypto.remote

import com.example.smaplesocketcrypto.data.model.LastPriceEntity
import com.example.smaplesocketcrypto.data.model.PriceChangePercentEntity
import com.example.smaplesocketcrypto.data.model.SymbolEntity
import com.example.smaplesocketcrypto.remote.mapper.PriceChangePercentEntityMapper
import com.example.smaplesocketcrypto.data.repository.ExampleConnectable
import com.example.smaplesocketcrypto.remote.mapper.LastPriceEntityMapper
import com.example.smaplesocketcrypto.remote.mapper.SymbolEntityMapper
import com.example.smaplesocketcrypto.remote.model.LastPrice
import com.example.smaplesocketcrypto.remote.model.PriceChangePercent
import com.example.smaplesocketcrypto.remote.model.Symbol
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.socket.emitter.Emitter
import javax.inject.Inject

class ExampleConnectableImpl @Inject constructor(
    private val appSocket: AppSocket,
    private val symbolEntityMapper : SymbolEntityMapper,
    private val lastPriceEntityMapper: LastPriceEntityMapper,
    private val priceChangePercentEntity: PriceChangePercentEntityMapper
) : ExampleConnectable {


    override val isConnected: Boolean get() = appSocket.isConnected

    private val symbol by lazy {
        Observable.create<Symbol> { emitter ->
            appSocket.on("modelA", Emitter.Listener {
                emitter.onNext(Symbol(""))
            })
        }.share()
    }

    private val lastPrice by lazy {
        Observable.create<LastPrice> { emitter ->
            appSocket.on("modelB", Emitter.Listener {
                emitter.onNext(LastPrice(""))
            })
        }.share()
    }

    private val priceChange by lazy {
        Observable.create<PriceChangePercent> { emitter ->
            appSocket.on("modelB", Emitter.Listener {
                emitter.onNext(PriceChangePercent(""))
            })
        }.share()
    }

    override fun getSymbolEntity(): Observable<SymbolEntity> {
        TODO("Not yet implemented")
    }

    override fun getLastPriceEntity(): Observable<LastPriceEntity> {
        TODO("Not yet implemented")
    }

    override fun getPriceChangePercentEntity(): Observable<PriceChangePercentEntity> {
        TODO("Not yet implemented")
    }

    override fun requestSymbolEntity(): Completable {
        TODO("Not yet implemented")
    }

    override fun requestLastPriceEntity(): Completable {
        TODO("Not yet implemented")
    }

    override fun requestPriceChangePercentEntity(): Completable {
        TODO("Not yet implemented")
    }


    override fun connect() = appSocket.connect()

    override fun disconnect() = appSocket.disconnect()



     fun getModelAStream(): Observable<ModelAEntity> = modelA.map { aMapper.mapFromRemote(it) }

     fun getModelBStream(): Observable<ModelBEntity> = modelB.map { bMapper.mapFromRemote(it) }

     fun requestModelA(): Completable = appSocket.request("modelA", Any())

     fun requestModelB(): Completable = appSocket.request("modelB", Any())
}