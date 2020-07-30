package com.davidgrajales.mymovies.model.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieFavoritesDAO {

    @Insert
    fun insertFavoriteMovie(favMov:MoviesFavorites)

    @Query("SELECT * FROM tab_fav")
    fun loadFavoriteMovie():List<MoviesFavorites>

    @Query("SELECT * FROM tab_fav WHERE id LIKE :id")
    fun searchFavoriteMovie(id:Int):MoviesFavorites

    @Delete
    fun deleteFavoriteMovie(favLocal: MoviesFavorites)

}