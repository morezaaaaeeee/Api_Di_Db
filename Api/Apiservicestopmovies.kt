package com.example.moivesbox.Api

import com.example.moivesbox.Modlse.Home.topmovies
import retrofit2.Response
import retrofit2.http.GET

interface Apiservicestopmovies   {
    //TopMovies
    @GET("top_rated?api_key=047f0e1fce693def844109011fac44d2&language=en-US&page=1")
    suspend fun Top_Movies(): Response<topmovies>
}