package com.pvld.horoscope.di.modules

import androidx.lifecycle.ViewModel
import com.pvld.horoscope.di.ViewModelKey
import com.pvld.horoscope.di.scopes.FragmentScope
import com.pvld.horoscope.ui.favorite.FavoriteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class FavoriteFragmentModule {

    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    internal abstract fun favoriteViewModel(viewModel: FavoriteViewModel): ViewModel

}