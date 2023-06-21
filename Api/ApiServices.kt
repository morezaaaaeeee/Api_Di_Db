package com.example.moivesbox.Api

import com.example.moivesbox.Modlse.Home.Genres_Modle
import com.example.moivesbox.Modlse.Home.TopMovies_moviesapi
import com.example.moivesbox.Modlse.Home.topmovies
import com.example.moivesbox.Modlse.Register.Body_Users
import com.example.moivesbox.Modlse.Register.Respons_Users
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {
    //Register
    @POST("register")
    suspend fun Login_Users(@Body body:Body_Users):Response<Respons_Users>

    //Get_List
    @GET("movies")
    suspend fun Get_Movies_List():Response<TopMovies_moviesapi>

    //Get_Genres
    suspend fun  Get_Genres_List():Response<Genres_Modle.Genres_ModleItem>

}