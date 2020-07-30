package com.davidgrajales.mymovies.ui.Favs

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidgrajales.mymovies.MyMovies
import com.davidgrajales.mymovies.R
import com.davidgrajales.mymovies.model.local.MoviesFavorites
import kotlinx.android.synthetic.main.fragment_favs.*

class FavsFragment : Fragment() , MovieFavoritesAdapter.OnItemClickListener{


    private var listMovies=ArrayList<MoviesFavorites>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_favs, container, false)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_favs.setHasFixedSize(true)
        rv_favs.layoutManager=LinearLayoutManager(
            requireContext(),RecyclerView.VERTICAL,false
        )
        listMovies=MyMovies.database.MovieFavoritesDAO().loadFavoriteMovie() as ArrayList<MoviesFavorites>

        val adapter= MovieFavoritesAdapter(listMovies,this@FavsFragment)
        rv_favs.adapter=adapter
    }

    override fun onItemClick(movie: MoviesFavorites) {

    }
}