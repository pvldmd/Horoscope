package com.pvld.horoscope.ui.zodiac

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pvld.horoscope.R
import com.pvld.horoscope.ui.sign.SignDetailFragment
import kotlinx.android.synthetic.main.fragment_zodiac.*

class ZodiacFragment : Fragment() {

    companion object {
        fun newInstance() = ZodiacFragment()
    }

    private lateinit var viewModel: ZodiacViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_zodiac, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ZodiacViewModel::class.java)
    }

    private fun setListeners() {
        val signViews = arrayListOf(allzodiac_sign1,
            allzodiac_sign2,
            allzodiac_sign3,
            allzodiac_sign4,
            allzodiac_sign5,
            allzodiac_sign6,
            allzodiac_sign7,
            allzodiac_sign8,
            allzodiac_sign9,
            allzodiac_sign10,
            allzodiac_sign11,
            allzodiac_sign12)

        for (view: View in signViews){
            view.setOnClickListener {
                startFragment(signViews.indexOf(view))
            }
        }
    }

    private fun startFragment (index: Int): Unit {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container_view_main, SignDetailFragment.newInstance(index), "SignDetailFragment")
            ?.addToBackStack(null)
            ?.commit()
    }

}
