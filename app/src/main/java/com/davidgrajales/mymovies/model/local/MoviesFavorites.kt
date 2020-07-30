package com.davidgrajales.mymovies.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tab_fav")
class MoviesFavorites (
    @PrimaryKey @ColumnInfo(name="id") val id:Int,
    @ColumnInfo(name="title") val title:String,
    @ColumnInfo(name="overview") val overview:String,
    @ColumnInfo(name="poster_path") val posterPath:String,
    @ColumnInfo(name="vote_average") val voteAverage: Double
)



