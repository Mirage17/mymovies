package com.davidgrajales.mymovies.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.davidgrajales.mymovies.model.remote.MovieRepository
import com.davidgrajales.mymovies.model.remote.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel(private  val moviesRepository: MovieRepository): ViewModel() {


   private val movies: MutableLiveData<List<Movies>> by lazy {
        MutableLiveData<List<Movies>>().also {
            loadMovies()
        }
    }

    fun getMovies(): LiveData<List<Movies>> {
        return movies
    }

    fun loadMovies(){
        GlobalScope.launch (Dispatchers.Main){
            movies.value=moviesRepository.getMovies().results as List<Movies>

        }
    }

}
// como tiene 2 argumentos es necesario hacer un factory

@Suppress("UNCHECKED CAST")
class ListViewModelFactory(private  val moviesRepository: MovieRepository):
    ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ListViewModel(moviesRepository) as T

}