package com.pvld.horoscope.di.components

import com.pvld.horoscope.di.modules.HoroscopeFragmentModule
import com.pvld.horoscope.di.scopes.FragmentScope
import com.pvld.horoscope.ui.horoscope.HoroscopeFragment
import dagger.Component

@FragmentScope
@Component(
    modules = [HoroscopeFragmentModule::class],
    dependencies = [AppComponent::class]
)
interface HoroscopeFragmentComponent {

    fun inject(horoscopeFragment: HoroscopeFragment)

}