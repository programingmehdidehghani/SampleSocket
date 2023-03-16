package com.example.smaplesocketcrypto.di

import com.example.smaplesocketcrypto.data.ExampleDataRepository
import com.example.smaplesocketcrypto.data.executor.JobExecutor
import com.example.smaplesocketcrypto.data.mapper.ChangePriceMapper
import com.example.smaplesocketcrypto.data.mapper.LastPriceMapper
import com.example.smaplesocketcrypto.data.mapper.SymbolMapper
import com.example.smaplesocketcrypto.data.repository.ExampleConnectable
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
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    internal fun provideExampleSocket(): AppSocket = AppSocketServiceFactory.exampleSocket()

    @Singleton
    @Provides
    internal fun provideExampleConnectable(
        exampleSocket: AppSocket,
        lastPriceEntityMapper: LastPriceEntityMapper,
        symbolEntityMapper: SymbolEntityMapper,
        priceChangePercentEntityMapper: PriceChangePercentEntityMapper
    ): ExampleConnectable =
        ExampleConnectableImpl(exampleSocket, symbolEntityMapper, lastPriceEntityMapper,priceChangePercentEntityMapper)

    @Provides
    @Singleton
    internal fun provideExampleRepository(
        connectable: ExampleConnectable,
        symbolMapper: SymbolMapper,
        lastPriceMapper: LastPriceMapper,
        changePriceMapper: ChangePriceMapper
    ): ExampleRepository =
        ExampleDataRepository(connectable, symbolMapper, lastPriceMapper,changePriceMapper)

    @Provides
    @Singleton
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor
}