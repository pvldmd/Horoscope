package com.pvld.horoscope.ui.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pvld.horoscope.R
import com.pvld.horoscope.data.model.FavoriteItem
import com.pvld.horoscope.di.components.DaggerCardFragmentComponent
import com.pvld.horoscope.di.components.DaggerFavoriteFragmentComponent
import com.pvld.horoscope.util.App
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteFragment : Fragment(), FavoriteItemAdapter.OnFavoriteClickListener {

    companion object {
        fun newInstance() = FavoriteFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var items: ArrayList<FavoriteItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoriteFragmentComponent.builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[FavoriteViewModel::class.java]

        //Set up the RecyclerView
        recycler_favorite.layoutManager = LinearLayoutManager(context)
        CoroutineScope(Dispatchers.Main).launch {
            val job = CoroutineScope(Dispatchers.IO).launch {
                items = viewModel.getFavoriteItems() as ArrayList<FavoriteItem>
            }
            job.join()
            if (items.isEmpty()) text_favorite_no_fav.visibility = View.VISIBLE
            val adapter =
                FavoriteItemAdapter(LayoutInflater.from(context), items, this@FavoriteFragment)
            recycler_favorite.adapter = adapter
        }

    }

    //Delete from the database and delete from the RecyclerView
    override fun onFavoriteClick(position: Int) {
        viewModel.deleteFavorite(items[position].sign, items[position].date)
        items.removeAt(position)
        recycler_favorite.adapter?.notifyDataSetChanged()
    }

}
