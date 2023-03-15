package com.example.smaplesocketcrypto.di

import com.example.smaplesocketcrypto.data.repository.ExampleConnectable
import com.example.smaplesocketcrypto.domain.repository.Connectable
import com.example.smaplesocketcrypto.domain.repository.ExampleRepository
import com.example.smaplesocketcrypto.domain.usecase.ExampleConnectableUseCase
import com.example.smaplesocketcrypto.remote.ExampleConnectableImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class ExampleConnectableUseCaseModule {

    @Binds
    @Singleton
    abstract fun bindExampleConnectableUseCase(exampleConnectableUseCase: ExampleConnectableUseCase): ExampleRepository


}