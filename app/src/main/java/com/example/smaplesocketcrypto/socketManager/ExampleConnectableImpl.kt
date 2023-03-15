package com.example.smaplesocketcrypto.socketManager

import com.example.smaplesocketcrypto.data.model.LastPriceEntity
import com.example.smaplesocketcrypto.data.model.PriceChangePercentEntity
import com.example.smaplesocketcrypto.data.model.SymbolEntity
import com.example.smaplesocketcrypto.socketManager.mapper.PriceChangePercentEntityMapper
import com.example.smaplesocketcrypto.data.repository.ExampleConnectable
import com.example.smaplesocketcrypto.socketManager.mapper.LastPriceEntityMapper
import com.example.smaplesocketcrypto.socketManager.mapper.SymbolEntityMapper
import com.example.smaplesocketcrypto.socketManager.model.LastPrice
import com.example.smaplesocketcrypto.socketManager.model.PriceChangePercent
import com.example.smaplesocketcrypto.socketManager.model.Symbol
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
            appSocket.on("s", Emitter.Listener {
                emitter.onNext(Symbol(""))
            })
        }.share()
    }

    private val lastPrice by lazy {
        Observable.create<LastPrice> { emitter ->
            appSocket.on("c", Emitter.Listener {
                emitter.onNext(LastPrice(""))
            })
        }.share()
    }

    private val priceChange by lazy {
        Observable.create<PriceChangePercent> { emitter ->
            appSocket.on("P", Emitter.Listener {
                emitter.onNext(PriceChangePercent(""))
            })
        }.share()
    }

    override fun getSymbolEntity(): Observable<SymbolEntity> = symbol.map { symbolEntityMapper.mapFromRemote(it) }

    override fun getLastPriceEntity(): Observable<LastPriceEntity> = lastPrice.map { lastPriceEntityMapper.mapFromRemote(it) }
    override fun getPriceChangePercentEntity(): Observable<PriceChangePercentEntity> = priceChange.map { priceChangePercentEntity.mapFromRemote(it) }
    override fun requestSymbolEntity(): Completable = appSocket.request("symbol", Any())

    override fun requestLastPriceEntity(): Completable = appSocket.request("lastPrice", Any())

    override fun requestPriceChangePercentEntity(): Completable = appSocket.request("priceChange", Any())

    override fun connect() = appSocket.connect()

    override fun disconnect() = appSocket.disconnect()

}