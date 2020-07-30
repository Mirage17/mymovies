package com.davidgrajales.mymovies.model.remote


import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDBService {

    @GET("movie/top_rated")
    suspend fun getTopRated(@Query("api_key") apikey: String):Movies

}