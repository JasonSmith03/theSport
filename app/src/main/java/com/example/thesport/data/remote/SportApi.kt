package com.example.thesport.data.remote

import com.example.thesport.domain.model.League
import com.example.thesport.domain.model.Status
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SportApi {

    @Headers(
        "x-rapidapi-host: $BASE_URL",
        "x-rapidapi-key: $API_KEY"
    )
    @GET("/status")
    suspend fun getStatus (): Status


    @Headers(
        "x-rapidapi-host: $BASE_URL",
        "x-rapidapi-key: $API_KEY"
    )
    @GET("/leagues")
    suspend fun getLeagues (@Query("id") paramId: Int): League


    companion object {
        const val API_KEY = "a3fa8171e98ed0d24d9fad81f9a99dd0"
        const val BASE_URL = "https://v1.hockey.api-sports.io"
        const val API_KEY_B = "45d2c07ca2d5a585d737fe26afc75a89"
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