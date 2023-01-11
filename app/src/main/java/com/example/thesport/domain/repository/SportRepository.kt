package com.example.thesport.domain.repository

import com.example.thesport.domain.model.*

interface SportRepository {
    //TODO - implement Resource as part of return values

    suspend fun getApiStatus(): Status

    suspend fun getLeague(leagueId: Int): League

    suspend fun getGame(leagueId: Int, seasonYr: Int, date: String): Games

    suspend fun getListOfMatchups(leagueId: Int, seasonYr: Int, date: String): MutableList<Matchup>

    suspend fun getOdds(league: Int, season: Int, bookmaker: Int, betType: Int): HashMap<Int, MutableList<String>>


}