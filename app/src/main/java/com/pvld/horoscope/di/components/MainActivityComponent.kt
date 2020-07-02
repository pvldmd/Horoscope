package com.pvld.horoscope.di.components

import com.pvld.horoscope.di.modules.MainActivityModule
import com.pvld.horoscope.di.scopes.ActivityScope
import com.pvld.horoscope.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [AppComponent::class]
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

}