package com.example.thesport.data.repository

import android.service.autofill.FieldClassification.Match
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.example.thesport.data.remote.SportApi
import com.example.thesport.domain.model.*
import com.example.thesport.domain.repository.SportRepository
import com.example.thesport.presentation.home.HomeScreenViewModel
import java.time.LocalDateTime
import java.util.Date
import javax.inject.Inject


class SportRepositoryImpl @Inject constructor(
    private val api: SportApi,
): SportRepository {

    /*
     * Note:
     *     these functions can become more complicated which is why we separate from the domain
     *     layer and remote api call.
     */

    override suspend fun getApiStatus(): Status {
        return api.getStatus()
    }

    override suspend fun getLeague(
        leagueId: Int
    ): League {
        return api.getLeagues(leagueId)
    }

    override suspend fun getGame(
        leagueId: Int,
        seasonYr: Int,
        date: String
    ): Games {
        return api.getGames(leagueId, seasonYr, date)
    }

    override suspend fun getListOfMatchups(
        leagueId: Int,
        seasonYr: Int,
        date: String
    ): MutableList<Matchup> {
        val games: Games = api.getGames(leagueId, seasonYr, date)
        //create empty list
        val matchupList = mutableListOf<Matchup>()
        for(responseElem in games.response){

            matchupList.add(
                Matchup(
                    responseElem.id,
                    responseElem.teams.home.logo,
                    responseElem.teams.home.name,
                    responseElem.scores.home?.toString() ?: responseElem.status.short,
                    responseElem.teams.away.logo,
                    responseElem.teams.away.name,
                    responseElem.scores.away?.toString() ?: responseElem.status.short
                )
            )
        }
        return matchupList
    }

    override suspend fun getOdds(
        league: Int,
        season: Int,
        bookmaker: Int,
        betType: Int,
    ): HashMap<Int, MutableList<String>> {
        val odds: Odds = api.getGameOdds(league, season, bookmaker, betType)
        val hashMap: HashMap<Int, MutableList<String>> = HashMap<Int,MutableList<String>>()
        val listOfBookmakerValues = mutableListOf<String>()
        val currentDate = LocalDateTime.now()

        for (responseElem in odds.response){
            Log.d(HomeScreenViewModel.TAG, odds.response.toString())
            if (currentDate.toString().substring(0, 10).equals(responseElem.game.date.substring(0, 10))){
                for(bookmaker in responseElem.bookmakers){
                    Log.d(HomeScreenViewModel.TAG, responseElem.bookmakers.toString())
                    for(bet in bookmaker.bet){
                        Log.d(HomeScreenViewModel.TAG, bookmaker.bet.toString())
                        for (value in bet.values){
                            Log.d(HomeScreenViewModel.TAG, bet.values.toString())
                            listOfBookmakerValues.add(value.odd)
                            hashMap.put(responseElem.game.id, listOfBookmakerValues)
                        }
                    }
                }
            }
        }

        return hashMap
    }

}