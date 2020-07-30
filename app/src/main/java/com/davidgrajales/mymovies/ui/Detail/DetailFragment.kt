package com.davidgrajales.mymovies.ui.Detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davidgrajales.mymovies.MyMovies
import com.davidgrajales.mymovies.R
import com.davidgrajales.mymovies.model.local.MoviesFavorites
import com.davidgrajales.mymovies.model.remote.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private lateinit var movie: Movie

   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeARgs= DetailFragmentArgs.fromBundle(it)
             movie=safeARgs.Movie
            setData(movie)
        }
        val favoritesDAO= MyMovies.database.MovieFavoritesDAO()

        val favMovieLocal = favoritesDAO.searchFavoriteMovie(movie.id)

        iv_fav.setOnClickListener {
            val favLocal = MoviesFavorites(
                id = movie.id,
                title = movie.title,
                overview = movie.overview,
                posterPath = movie.posterPath,
                voteAverage = movie.voteAverage
            )
            if (favMovieLocal == null) {
                favoritesDAO.insertFavoriteMovie(favLocal)
                    iv_fav.setImageDrawable(resources.getDrawable(android.R.drawable.star_big_on))
            } else {
                favoritesDAO.deleteFavoriteMovie(favLocal)
                iv_fav.setImageDrawable(resources.getDrawable(android.R.drawable.star_big_off))
            }
        }
    }

    private fun setData(movie: Movie) {
        val URL_IMAGES = "https://image.tmdb.org/t/p/w500"

        tv_title_details.text = movie.title
        tv_detailed_budget.text=movie.voteAverage.toString()
        tv_review.text=movie.overview
        Picasso.get().load(URL_IMAGES + movie.posterPath).into(iv_detail_poster)
    }


}