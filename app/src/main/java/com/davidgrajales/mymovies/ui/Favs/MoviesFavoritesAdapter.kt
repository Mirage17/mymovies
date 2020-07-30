package com.davidgrajales.mymovies.ui.Favs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davidgrajales.mymovies.R
import com.davidgrajales.mymovies.model.local.MoviesFavorites
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MovieFavoritesAdapter(
    val moviesList: ArrayList<MoviesFavorites>,
    val onItemClickListener: OnItemClickListener
):
    RecyclerView.Adapter<MovieFavoritesAdapter.MoviesViewHolder>(){

    class MoviesViewHolder(itemView: View, var onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        fun setMovie(movie: MoviesFavorites) {
            val URL_IMAGES = "https://image.tmdb.org/t/p/w500"

            itemView.tv_tittle.text=movie.title
           itemView.tv_average.text=movie.voteAverage.toString()
            Picasso.get().load(URL_IMAGES +movie.posterPath).into(itemView.ivposter)
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(movie)

            }
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item,parent,false)
        return MoviesViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount(): Int = moviesList.size


    override fun onBindViewHolder(holder: MovieFavoritesAdapter.MoviesViewHolder, position: Int) {
       val movie=moviesList[position]
        holder.setMovie(movie)
    }



    interface OnItemClickListener {
        fun onItemClick(movie: MoviesFavorites)
    }
}