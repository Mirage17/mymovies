package com.davidgrajales.mymovies.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidgrajales.mymovies.R
import com.davidgrajales.mymovies.model.remote.Movie
import com.davidgrajales.mymovies.model.remote.MovieRepository
import com.davidgrajales.mymovies.model.remote.Movies
import com.davidgrajales.mymovies.model.remote.TheMovieDBService
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment(), MovieAdapter.OnItemClickListener {


    private  var listMovies=ArrayList<Movie>()
    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_list, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel= ViewModelProvider(
            this,
            ListViewModelFactory(MovieRepository())
        ).get()

        rv_list.setHasFixedSize(true)
        rv_list.layoutManager=LinearLayoutManager(
            requireContext(),RecyclerView.VERTICAL,false
        )


        listViewModel.getMovies().observe(viewLifecycleOwner, Observer {
            val adapter= MovieAdapter(it as ArrayList<Movie>,this@ListFragment)
            rv_list.adapter=adapter

        })
    }



    override fun onItemClick(movie: Movie) {
        val action =ListFragmentDirections.actionNavigationListToDetailFragment(movie)
        findNavController().navigate(action)
    }

}