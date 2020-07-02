package com.pvld.horoscope.ui.horoscope

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.pvld.horoscope.R
import com.pvld.horoscope.di.components.DaggerHoroscopeFragmentComponent
import com.pvld.horoscope.ui.settings.SettingsActivity
import com.pvld.horoscope.util.App
import kotlinx.android.synthetic.main.fragment_horoscope.*
import javax.inject.Inject


class HoroscopeFragment : Fragment() {

    companion object {
        fun newInstance() = HoroscopeFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: HoroscopeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_horoscope, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set up the ViewPager with the TabLayout
        val viewPager = view.findViewById(R.id.viewpager_horoscope) as ViewPager
        val adapter = context?.let { HoroscopePagerAdapter(childFragmentManager, it) }
        viewPager.adapter = adapter
        viewPager.currentItem = 1
        val tabLayout: TabLayout = view.findViewById(R.id.tabs_horoscope)
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerHoroscopeFragmentComponent.builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[HoroscopeViewModel::class.java]

        // Observe changes in the current zodiac sign
        viewModel.currentSign.observe(
            viewLifecycleOwner,
            Observer<String> { sign -> updateViews(sign) }
        )

        // Settings button listener
        image_horoscope_settings.setOnClickListener {
            val intent = Intent(context, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateViews(sign: String) {
        when (sign) {
            "aries" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_aries)
                text_horoscope_signname.text = getString(R.string.aries)
                text_horoscope_signdates.text = getString(R.string.all_aries_dates)
            }
            "taurus" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_taurus)
                text_horoscope_signname.text = getString(R.string.taurus)
                text_horoscope_signdates.text = getString(R.string.all_taurus_dates)
            }
            "gemini" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_gemini)
                text_horoscope_signname.text = getString(R.string.gemini)
                text_horoscope_signdates.text = getString(R.string.all_gemini_dates)
            }
            "cancer" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_cancer)
                text_horoscope_signname.text = getString(R.string.cancer)
                text_horoscope_signdates.text = getString(R.string.all_cancer_dates)
            }
            "leo" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_leo)
                text_horoscope_signname.text = getString(R.string.leo)
                text_horoscope_signdates.text = getString(R.string.all_leo_dates)
            }
            "virgo" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_virgo)
                text_horoscope_signname.text = getString(R.string.virgo)
                text_horoscope_signdates.text = getString(R.string.all_virgo_dates)
            }
            "libra" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_libra)
                text_horoscope_signname.text = getString(R.string.libra)
                text_horoscope_signdates.text = getString(R.string.all_libra_dates)
            }
            "scorpio" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_scorpio)
                text_horoscope_signname.text = getString(R.string.scorpio)
                text_horoscope_signdates.text = getString(R.string.all_scorpio_dates)
            }
            "sagittarius" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_sagittarius)
                text_horoscope_signname.text = getString(R.string.sagittarius)
                text_horoscope_signdates.text = getString(R.string.all_sagittarius_dates)
            }
            "capricorn" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_capricorn)
                text_horoscope_signname.text = getString(R.string.capricorn)
                text_horoscope_signdates.text = getString(R.string.all_capricorn_dates)
            }
            "aquarius" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_aquarius)
                text_horoscope_signname.text = getString(R.string.aquarius)
                text_horoscope_signdates.text = getString(R.string.all_aquarius_dates)
            }
            "pisces" -> {
                image_horoscope_signicon.setImageResource(R.drawable.ic_zodiac_pisces)
                text_horoscope_signname.text = getString(R.string.pisces)
                text_horoscope_signdates.text = getString(R.string.all_pisces_dates)
            }
        }
    }

}
