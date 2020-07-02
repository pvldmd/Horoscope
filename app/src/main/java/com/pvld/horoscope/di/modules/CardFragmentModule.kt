package com.pvld.horoscope.di.modules

import androidx.lifecycle.ViewModel
import com.pvld.horoscope.di.ViewModelKey
import com.pvld.horoscope.di.scopes.FragmentScope
import com.pvld.horoscope.ui.horoscope.card.CardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class CardFragmentModule {

    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(CardViewModel::class)
    internal abstract fun cardViewModel(viewModel: CardViewModel): ViewModel

}