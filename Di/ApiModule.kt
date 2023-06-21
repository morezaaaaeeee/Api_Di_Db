package com.example.moivesbox.Di

import com.example.moivesbox.Api.ApiServices
import com.example.moivesbox.Api.Apiservicestopmovies
import com.example.moivesbox.Utils.constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Named("Base_Url_movies_api")
    fun Base_Url_movies_api() = constants.Base_Url_moviesapi

    @Provides
    fun Base_Url_movies_Db() = constants.Base_Url_movies_Db

    @Provides
    @Singleton
    fun Time() = constants.Time

    @Provides
    @Singleton
    fun Gson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun Interceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun OkHttpClient(Time: Long, Interceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .readTimeout(Time, TimeUnit.SECONDS)
        .writeTimeout(Time, TimeUnit.SECONDS)
        .connectTimeout(Time, TimeUnit.SECONDS)
        .addInterceptor(Interceptor)
        .build()

    @Provides
    @Singleton
    fun Retrofit(@Named("Base_Url_movies_api") URL: String, Gson: Gson, Client: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(Gson))
            .client(Client)
            .build()
            .create(ApiServices::class.java)
}

/*
    @Provides
    @Singleton
    fun Retrofit_Movies_Db(URL:String,Gson:Gson,Client:OkHttpClient)=
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(Gson))
            .client(Client)
            .build()
            .create(Apiservicestopmovies::class.java)
}*/
