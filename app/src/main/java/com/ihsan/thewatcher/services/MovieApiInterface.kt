package com.ihsan.thewatcher.services

import com.ihsan.thewatcher.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=334ec1a030f70e8ca361cebae6586ec9")
    fun getMovieList(): Call<MovieResponse>
}