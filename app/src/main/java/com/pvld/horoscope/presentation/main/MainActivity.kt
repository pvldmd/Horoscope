package com.pvld.horoscope.presentation.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.preference.PreferenceManager
import com.pvld.horoscope.R
import com.pvld.horoscope.data.database.Horoscope
import com.pvld.horoscope.presentation.favorite.FavoriteFragment
import com.pvld.horoscope.presentation.horoscope.HoroscopeFragment
import com.pvld.horoscope.presentation.selectsign.SelectSignActivity
import com.pvld.horoscope.presentation.zodiac.ZodiacFragment
import com.pvld.horoscope.util.CONSTANTS.MY_LOG_INFO
import com.pvld.horoscope.util.CONSTANTS.PREFS_FIRST_START
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainActivityViewModel by viewModels()

        // At the first launch of the app, show the zodiac sign selection screen and loader
        if (viewModel.isFirstLaunch()) {
            startActivity(Intent(this, SelectSignActivity::class.java))
            bottom_navigation_main.visibility = View.GONE
            group_loader_main.visibility = View.VISIBLE
            viewModel.horoscopeAllObservable.observe(this, Observer<List<Horoscope>> {
                if (it.isNotEmpty()) {
                    viewModel.horoscopeAllObservable.removeObservers(this)
                    viewModel.setFirstLaunchFalse()
                    bottom_navigation_main.visibility = View.VISIBLE
                    group_loader_main.visibility = View.GONE
                }
            })
        }

        //Show a fragment with a horoscope
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_main, HoroscopeFragment.newInstance())
            .commit()
        bottom_navigation_main.menu.getItem(0).isChecked = true

        // Bottom navigation menu listener
        bottom_navigation_main.setOnNavigationItemSelectedListener { item: MenuItem ->
            when(item.itemId){
                R.id.action_horoscope -> {
                    if (!item.isChecked){
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container_view_main, HoroscopeFragment.newInstance())
                            .commit()
                    }
                    item.isChecked = true
                }
                R.id.action_zodiac -> {
                    if (!item.isChecked){
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container_view_main, ZodiacFragment.newInstance())
                            .commit()
                    }
                    item.isChecked = true
                }
                R.id.action_favorite -> {
                    if (!item.isChecked){
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container_view_main, FavoriteFragment.newInstance())
                            .commit()
                    }
                    item.isChecked = true
                }

            }
            false
        }

    }

}
