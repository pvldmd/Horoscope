package com.pvld.horoscope.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.pvld.horoscope.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MainActivityViewModel by viewModels()

        model.getSign("aries").observe(this, Observer{ horoscope ->
            text_view.text = horoscope.horoscopeToday
        })
    }

}
