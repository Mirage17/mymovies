package com.davidgrajales.mymovies.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MoviesFavorites::class),version=1)
abstract class MoviesFavoritesDatabase: RoomDatabase(){
    abstract  fun MovieFavoritesDAO():MovieFavoritesDAO
}