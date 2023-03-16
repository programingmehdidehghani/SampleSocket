package com.example.smaplesocketcrypto.di.module

import com.example.smaplesocketcrypto.di.componet.MainActivitySubComponent
import com.example.smaplesocketcrypto.di.scops.PerActivity
import com.example.smaplesocketcrypto.presention.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(subcomponents = [(MainActivitySubComponent::class)])
abstract class ActivityBindingModule {


    @PerActivity
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity
}