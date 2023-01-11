package com.example.thesport.data.remote

import com.example.thesport.BuildConfig
import com.example.thesport.domain.model.*
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.Date

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
    @GET("/seasons")
    suspend fun getSeason(): Season

    @Headers(
        "x-rapidapi-host: $BASE_URL",
        "x-rapidapi-key: $API_KEY"
    )
    @GET("/leagues")
    suspend fun getLeagues (@Query("id") paramId: Int): League

    @Headers(
        "x-rapidapi-host: $BASE_URL",
        "x-rapidapi-key: $API_KEY"
    )
    @GET("/games")
    suspend fun getGames(@Query("league") leagueId: Int, @Query("season") seasonYr: Int, @Query("date") date: String): Games

    @Headers(
        "x-rapidapi-host: $BASE_URL",
        "x-rapidapi-key: $API_KEY"
    )
    @GET("/odds")
    suspend fun getGameOdds(@Query("league") leagueId: Int, @Query("season") seasonYr: Int, @Query("bookmaker") bookmaker: Int, @Query("bet") betType: Int): Odds

    companion object {
        const val API_KEY = BuildConfig.API_KEY
        const val BASE_URL = "https://v1.hockey.api-sports.io"
    }

}