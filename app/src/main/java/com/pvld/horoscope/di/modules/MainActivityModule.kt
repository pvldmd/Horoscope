package com.pvld.horoscope.di.modules

import androidx.lifecycle.ViewModel
import com.pvld.horoscope.di.ViewModelKey
import com.pvld.horoscope.di.scopes.ActivityScope
import com.pvld.horoscope.ui.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class MainActivityModule {

    @Binds
    @ActivityScope
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun mainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

}