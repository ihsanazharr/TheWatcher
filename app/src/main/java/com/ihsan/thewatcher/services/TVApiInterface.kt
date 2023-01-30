package com.ihsan.thewatcher.services

import com.ihsan.thewatcher.models.TVResponse
import retrofit2.Call
import retrofit2.http.GET

interface TVApiInterface {
    @GET("/3/tv/popular?api_key=334ec1a030f70e8ca361cebae6586ec9")
    fun  getTVList(): Call<TVResponse>
}