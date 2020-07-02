package com.pvld.horoscope.di.modules

import androidx.lifecycle.ViewModel
import com.pvld.horoscope.di.ViewModelKey
import com.pvld.horoscope.di.scopes.FragmentScope
import com.pvld.horoscope.ui.horoscope.HoroscopeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class HoroscopeFragmentModule {

    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(HoroscopeViewModel::class)
    internal abstract fun horoscopeViewModel(viewModel: HoroscopeViewModel): ViewModel

}