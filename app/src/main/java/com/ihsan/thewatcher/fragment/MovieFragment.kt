package com.ihsan.thewatcher.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ihsan.thewatcher.R
import com.ihsan.thewatcher.adapter.MovieAdapter
import com.ihsan.thewatcher.models.Movie
import com.ihsan.thewatcher.models.MovieResponse
import com.ihsan.thewatcher.services.MovieApiInterface
import com.ihsan.thewatcher.services.MovieApiService
import kotlinx.android.synthetic.main.fragment_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFragment : Fragment() {

    private val movies = arrayListOf<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_movies_list.layoutManager = LinearLayoutManager(this.context)
        rv_movies_list.setHasFixedSize(true)

        getMovieData{ movies : List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }
        showRecyclerView()
    }

    private fun showRecyclerView() {

        rv_movies_list.layoutManager = LinearLayoutManager(this.context)
        rv_movies_list.adapter = MovieAdapter(movies)
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }




}