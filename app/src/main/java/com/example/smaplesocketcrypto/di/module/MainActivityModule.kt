package com.example.smaplesocketcrypto.di.module

import com.example.smaplesocketcrypto.di.scops.PerActivity
import com.example.smaplesocketcrypto.domain.usecase.ExampleConnectableUseCase
import com.example.smaplesocketcrypto.presention.MainActivity
import com.example.smaplesocketcrypto.presention.MinViewModel
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(
        exampleConnectableUseCase: ExampleConnectableUseCase
    ): MinViewModel = MinViewModel(exampleConnectableUseCase)
}