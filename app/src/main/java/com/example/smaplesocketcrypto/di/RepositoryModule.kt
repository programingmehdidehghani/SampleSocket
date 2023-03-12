package com.example.smaplesocketcrypto.di

import com.example.smaplesocketcrypto.data.CryptoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        cryptoRepository : CryptoRepository
    ): com.example.smaplesocketcrypto.domain.CryptoRepository
}