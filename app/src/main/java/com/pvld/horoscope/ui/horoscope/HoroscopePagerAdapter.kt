package com.pvld.horoscope.ui.horoscope

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.pvld.horoscope.ui.horoscope.card.CardFragment

private const val PAGE_COUNT = 4

class HoroscopePagerAdapter(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {
    private val tabTitles =
        arrayOf("Вчера", "Сегодня", "Завтра", "Послезавтра")


    override fun getItem(position: Int): Fragment {
        return CardFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}