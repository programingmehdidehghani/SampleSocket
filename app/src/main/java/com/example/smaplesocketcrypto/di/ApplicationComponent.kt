package com.example.smaplesocketcrypto.di

import android.app.Application
import com.example.smaplesocketcrypto.CryptoApplication
import com.example.smaplesocketcrypto.di.module.ActivityBindingModule
import com.example.smaplesocketcrypto.di.module.ApplicationModule
import com.example.smaplesocketcrypto.di.scops.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule


@PerApplication
@Component(modules = arrayOf(
    ActivityBindingModule::class, ApplicationModule::class,
    AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: CryptoApplication)
}