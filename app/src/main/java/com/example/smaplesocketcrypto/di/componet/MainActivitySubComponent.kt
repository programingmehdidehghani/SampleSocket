package com.example.smaplesocketcrypto.di.componet

import com.example.smaplesocketcrypto.presention.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface MainActivitySubComponent {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}