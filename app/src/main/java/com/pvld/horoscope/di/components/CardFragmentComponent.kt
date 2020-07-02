package com.pvld.horoscope.di.components

import com.pvld.horoscope.di.modules.CardFragmentModule
import com.pvld.horoscope.di.scopes.FragmentScope
import com.pvld.horoscope.ui.horoscope.card.CardFragment
import dagger.Component

@FragmentScope
@Component(
    modules = [CardFragmentModule::class],
    dependencies = [AppComponent::class]
)
interface CardFragmentComponent {

    fun inject(cardFragment: CardFragment)

}