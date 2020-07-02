package com.pvld.horoscope.di.components

import com.pvld.horoscope.di.modules.FavoriteFragmentModule
import com.pvld.horoscope.di.scopes.FragmentScope
import com.pvld.horoscope.ui.favorite.FavoriteFragment
import dagger.Component

@FragmentScope
@Component(
    modules = [FavoriteFragmentModule::class],
    dependencies = [AppComponent::class]
)
interface FavoriteFragmentComponent {

    fun inject(favoriteFragment: FavoriteFragment)

}