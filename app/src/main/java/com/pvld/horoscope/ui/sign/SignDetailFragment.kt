package com.pvld.horoscope.ui.sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pvld.horoscope.R
import kotlinx.android.synthetic.main.fragment_sign_detail.*

private const val SIGN_INDEX = "signIndex"

class SignDetailFragment : Fragment() {

    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            index = it.getInt(SIGN_INDEX)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews(index)
    }

    fun setViews(signIndex: Int) {
        when (signIndex) {
            0 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_aries)
                text_signdetail_signname.text = getString(R.string.aries)
                text_signdetail_signdates.text = getString(R.string.all_aries_dates)
                text_signdetail_text.text = getString(R.string.signdetail_aries)
            }
            1 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_taurus)
                text_signdetail_signname.text = getString(R.string.taurus)
                text_signdetail_signdates.text = getString(R.string.all_taurus_dates)
                text_signdetail_text.text = getString(R.string.signdetail_taurus)
            }
            2 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_gemini)
                text_signdetail_signname.text = getString(R.string.gemini)
                text_signdetail_signdates.text = getString(R.string.all_gemini_dates)
                text_signdetail_text.text = getString(R.string.signdetail_gemini)
            }
            3 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_cancer)
                text_signdetail_signname.text = getString(R.string.cancer)
                text_signdetail_signdates.text = getString(R.string.all_cancer_dates)
                text_signdetail_text.text = getString(R.string.signdetail_cancer)
            }
            4 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_leo)
                text_signdetail_signname.text = getString(R.string.leo)
                text_signdetail_signdates.text = getString(R.string.all_leo_dates)
                text_signdetail_text.text = getString(R.string.signdetail_leo)
            }
            5 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_virgo)
                text_signdetail_signname.text = getString(R.string.virgo)
                text_signdetail_signdates.text = getString(R.string.all_virgo_dates)
                text_signdetail_text.text = getString(R.string.signdetail_virgo)
            }
            6 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_libra)
                text_signdetail_signname.text = getString(R.string.libra)
                text_signdetail_signdates.text = getString(R.string.all_libra_dates)
                text_signdetail_text.text = getString(R.string.signdetail_libra)
            }
            7 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_scorpio)
                text_signdetail_signname.text = getString(R.string.scorpio)
                text_signdetail_signdates.text = getString(R.string.all_scorpio_dates)
                text_signdetail_text.text = getString(R.string.signdetail_scorpio)
            }
            8 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_sagittarius)
                text_signdetail_signname.text = getString(R.string.sagittarius)
                text_signdetail_signdates.text = getString(R.string.all_sagittarius_dates)
                text_signdetail_text.text = getString(R.string.signdetail_sagittarius)
            }
            9 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_capricorn)
                text_signdetail_signname.text = getString(R.string.capricorn)
                text_signdetail_signdates.text = getString(R.string.all_capricorn_dates)
                text_signdetail_text.text = getString(R.string.signdetail_capricorn)
            }
            10 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_aquarius)
                text_signdetail_signname.text = getString(R.string.aquarius)
                text_signdetail_signdates.text = getString(R.string.all_aquarius_dates)
                text_signdetail_text.text = getString(R.string.signdetail_aquarius)
            }
            11 -> {
                image_signdetail_signicon.setImageResource(R.drawable.ic_zodiac_pisces)
                text_signdetail_signname.text = getString(R.string.pisces)
                text_signdetail_signdates.text = getString(R.string.all_pisces_dates)
                text_signdetail_text.text = getString(R.string.signdetail_pisces)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(index: Int) =
            SignDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(SIGN_INDEX, index)
                }
            }
    }
}
