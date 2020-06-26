package com.pvld.horoscope.data.preferences

import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import androidx.lifecycle.LiveData
import com.pvld.horoscope.util.App


class SharedPreferenceStringLiveData(private val key: String, private val defaultValue: String): LiveData<String>() {

    private val sharedPrefs = App.preferences

    private val listener =
        OnSharedPreferenceChangeListener { _, changedKey ->
            if (key == changedKey) {
                value = sharedPrefs.getString(key, defaultValue)
            }
        }

    override fun onActive() {
        super.onActive()
        value = sharedPrefs.getString(key, defaultValue)
        sharedPrefs.registerOnSharedPreferenceChangeListener(listener)
    }

    override fun onInactive() {
        super.onInactive()
        sharedPrefs.unregisterOnSharedPreferenceChangeListener(listener)
    }
}