package com.example.thesport.data.remote.dto

import com.example.thesport.domain.model.League
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SportApi {

    @GET("/leagues")
    suspend fun getLeagues (@Query("key") apiKey: String): Response<League>

    companion object{
        const val API_KEY = "5d8420e5c432ced17813f85f0eb8663d"
        const val BASE_URL = "https://v1.hockey.api-sports.io"
    }


}