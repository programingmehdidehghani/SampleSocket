package com.example.smaplesocketcrypto.di.module

import android.app.Application
import android.content.Context
import com.example.smaplesocketcrypto.data.ExampleDataRepository
import com.example.smaplesocketcrypto.data.executor.JobExecutor
import com.example.smaplesocketcrypto.data.mapper.ChangePriceMapper
import com.example.smaplesocketcrypto.data.mapper.LastPriceMapper
import com.example.smaplesocketcrypto.data.mapper.SymbolMapper
import com.example.smaplesocketcrypto.data.repository.ExampleConnectable
import com.example.smaplesocketcrypto.di.scops.PerApplication
import com.example.smaplesocketcrypto.domain.executor.PostExecutionThread
import com.example.smaplesocketcrypto.domain.executor.ThreadExecutor
import com.example.smaplesocketcrypto.domain.repository.ExampleRepository
import com.example.smaplesocketcrypto.remote.AppSocket
import com.example.smaplesocketcrypto.remote.AppSocketServiceFactory
import com.example.smaplesocketcrypto.remote.ExampleConnectableImpl
import com.example.smaplesocketcrypto.remote.mapper.LastPriceEntityMapper
import com.example.smaplesocketcrypto.remote.mapper.PriceChangePercentEntityMapper
import com.example.smaplesocketcrypto.remote.mapper.SymbolEntityMapper
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context = application

    @Provides
    @PerApplication
    internal fun provideExampleSocket(): AppSocket = AppSocketServiceFactory.exampleSocket()

    @Provides
    @PerApplication
    internal fun provideExampleConnectable(
        exampleSocket: AppSocket,
        lastPriceEntityMapper: LastPriceEntityMapper,
        symbolEntityMapper: SymbolEntityMapper,
        priceChangePercentEntityMapper: PriceChangePercentEntityMapper
    ): ExampleConnectable =
        ExampleConnectableImpl(exampleSocket, symbolEntityMapper, lastPriceEntityMapper,priceChangePercentEntityMapper)

    @Provides
    @PerApplication
    internal fun provideExampleRepository(
        connectable: ExampleConnectable,
        symbolMapper: SymbolMapper,
        lastPriceMapper: LastPriceMapper,
        changePriceMapper: ChangePriceMapper
    ): ExampleRepository =
        ExampleDataRepository(connectable, symbolMapper, lastPriceMapper,changePriceMapper)

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread = uiThread
}