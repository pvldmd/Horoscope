package com.pvld.horoscope.di.components

import com.pvld.horoscope.di.modules.SelectSignActivityModule
import com.pvld.horoscope.di.scopes.ActivityScope
import com.pvld.horoscope.ui.selectsign.SelectSignActivity
import dagger.Component

@ActivityScope
@Component(
    modules = [SelectSignActivityModule::class],
    dependencies = [AppComponent::class]
)
interface SelectSignActivityComponent {

    fun inject(selectSignActivity: SelectSignActivity)

}