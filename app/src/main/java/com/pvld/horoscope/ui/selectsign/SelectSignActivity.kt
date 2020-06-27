package com.pvld.horoscope.ui.selectsign

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pvld.horoscope.R
import com.pvld.horoscope.util.CONSTANTS.MY_LOG_INFO


class SelectSignActivity : AppCompatActivity() {

    private lateinit var viewModel: SelectSignViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_sign)
        viewModel = ViewModelProvider(this).get(SelectSignViewModel::class.java)
    }

    fun onClickSign(view: View) {
        Log.i(MY_LOG_INFO, view.id.toString())
        when (view.id) {
            R.id.view_selectsign_aries -> viewModel.setCurrentSign("aries")
            R.id.view_selectsign_taurus -> viewModel.setCurrentSign("taurus")
            R.id.view_selectsign_gemini -> viewModel.setCurrentSign("gemini")
            R.id.view_selectsign_leo -> viewModel.setCurrentSign("leo")
            R.id.view_selectsign_virgo -> viewModel.setCurrentSign("virgo")
            R.id.view_selectsign_libra -> viewModel.setCurrentSign("libra")
            R.id.view_selectsign_cancer -> viewModel.setCurrentSign("cancer")
            R.id.view_selectsign_scorpio -> viewModel.setCurrentSign("scorpio")
            R.id.view_selectsign_sagittarius -> viewModel.setCurrentSign("sagittarius")
            R.id.view_selectsign_capricorn -> viewModel.setCurrentSign("capricorn")
            R.id.view_selectsign_aquarius -> viewModel.setCurrentSign("aquarius")
            R.id.view_selectsign_pisces -> viewModel.setCurrentSign("pisces")
        }
        finish()
    }

}
