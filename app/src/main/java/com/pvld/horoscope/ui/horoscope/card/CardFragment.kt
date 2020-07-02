package com.pvld.horoscope.ui.horoscope.card

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pvld.horoscope.R
import com.pvld.horoscope.data.database.Favorite
import com.pvld.horoscope.data.database.Horoscope
import com.pvld.horoscope.di.components.DaggerCardFragmentComponent
import com.pvld.horoscope.util.App
import kotlinx.android.synthetic.main.fragment_card.*
import javax.inject.Inject


private const val POSITION = "position"

class CardFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CardViewModel
    private var position: Int = 0
    private lateinit var currentSign: String
    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerCardFragmentComponent.builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[CardViewModel::class.java]

        // Observe changes in the current zodiac sign
        viewModel.currentSign.observe(
            viewLifecycleOwner,
            Observer<String> { sign ->
                currentSign = sign
                setHoroscopeObserver()
            }
        )

        // Favorites button listener
        image_card_fav.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (isFavorite) {
                    viewModel.deleteFavorite(currentSign, text_cardfr_date.text.toString())
                } else {
                    viewModel.createFavorite(
                        currentSign,
                        text_cardfr_date.text.toString(),
                        text_cardfr_horoscope.text.toString()
                    )
                }
            }
        })
    }

    // Observe changes in the horoscope data
    private fun setHoroscopeObserver() {
        viewModel.horoscopeAllObservable.observe(
            viewLifecycleOwner,
            Observer<List<Horoscope>> { list ->
                for (horoscope in list) {
                    if (horoscope.sign == currentSign) {
                        updateDateAndText(horoscope)
                    }
                }
                setIsFavoriteObserver()
            }
        )
    }

    // Observe changes - in favorites or not
    private fun setIsFavoriteObserver() {
        viewModel.getOneFavorite(currentSign, text_cardfr_date.text.toString()).observe(
            viewLifecycleOwner,
            Observer<List<Favorite>> { list ->
                isFavorite = if (list.isNotEmpty()) {
                    image_card_fav.setImageResource(R.drawable.ic_favorite_checked)
                    true
                } else {
                    image_card_fav.setImageResource(R.drawable.ic_menu_favorite)
                    false
                }
            })
    }

    private fun updateDateAndText(h: Horoscope) {
        when (position) {
            0 -> {
                text_cardfr_horoscope.text = h.horoscopeYesterday
                text_cardfr_date.text = h.dateYesterday
            }
            1 -> {
                text_cardfr_horoscope.text = h.horoscopeToday
                text_cardfr_date.text = h.dateToday
            }
            2 -> {
                text_cardfr_horoscope.text = h.horoscopeTommorow
                text_cardfr_date.text = h.dateTommorow
            }
            3 -> {
                text_cardfr_horoscope.text = h.horoscopeTommorow02
                text_cardfr_date.text = h.dateTommorow02
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            CardFragment().apply {
                arguments = Bundle().apply {
                    putInt(POSITION, position)
                }
            }
    }

}
