package com.davidgrajales.mymovies

import android.app.Application
import androidx.room.Room
import com.davidgrajales.mymovies.model.local.MoviesFavoritesDatabase


class MyMovies:Application() {
    companion object {
        lateinit var database: MoviesFavoritesDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database= Room.databaseBuilder(
            this,
            MoviesFavoritesDatabase::class.java,
            "MyMovies_db"
        ).allowMainThreadQueries().build()
    }


}