package com.pvld.horoscope.di.modules

import androidx.lifecycle.ViewModel
import com.pvld.horoscope.di.ViewModelKey
import com.pvld.horoscope.di.scopes.ActivityScope
import com.pvld.horoscope.ui.selectsign.SelectSignViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class SelectSignActivityModule {

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(SelectSignViewModel::class)
    internal abstract fun selectSignViewModel(viewModel: SelectSignViewModel): ViewModel

}