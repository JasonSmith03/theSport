package com.example.thesport.data.remote.dto

import com.example.thesport.domain.model.League
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SportApi {

    @GET("/leagues")
    suspend fun getLeagues (
        @Query("x-apisports-key") apiKey: String = API_KEY): Response<League>


    companion object {
        const val API_KEY = "5d8420e5c432ced17813f85f0eb8663d"
        const val BASE_URL = "https://v1.hockey.api-sports.io"
    }


}

object TheSportRetrofitInstance{
    val api: SportApi by lazy {
        Retrofit.Builder()
            .baseUrl(SportApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SportApi::class.java)
    }
}