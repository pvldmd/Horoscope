package com.pvld.horoscope.di.modules

import androidx.lifecycle.ViewModelProvider
import com.pvld.horoscope.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}