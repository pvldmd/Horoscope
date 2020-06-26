package com.pvld.horoscope.presentation.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pvld.horoscope.R


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_settings, SettingsFragment())
            .commit()


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
