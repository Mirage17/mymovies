package com.davidgrajales.mymovies.model.remote


class MovieRepository {


    val apiKey = "e6cd79bb46cb012720e1f297c8d4f1ed"

    suspend fun getMovies() = MovieDb.retrofit.getTopRated(apiKey)

}