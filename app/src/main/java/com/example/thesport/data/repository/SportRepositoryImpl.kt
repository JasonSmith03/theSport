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
import com.squareup.moshi.Json
import org.json.JSONObject
import java.text.ChoiceFormat.nextDouble
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashMap
import kotlin.random.Random


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
        //, bookmaker, betType
        val odds: Odds = api.getGameOdds(league, season, bookmaker, betType)
        val hashMap: HashMap<Int, MutableList<String>> = HashMap<Int,MutableList<String>>()
        val UTCdate = getCurrentUTC()

        for (responseElem in odds.response){
            Log.d(HomeScreenViewModel.TAG, "get odds response" + odds.response.toString())
            if (UTCdate.toString().substring(0, 10).equals(responseElem.game.date.substring(0, 10))){
                for(bookmaker in responseElem.bookmakers){
                    Log.d(HomeScreenViewModel.TAG, "response bookmaker" + responseElem.bookmakers.toString())
                    val listOfBookmakerValues:  MutableList<String> = mutableListOf(Math.round(Random.nextDouble(-5.0, 5.0) * 100.0 / 100.0).toString(), Math.round(Random.nextDouble(-5.0, 5.0) * 100.0 / 100.0).toString())
                    if (bookmaker.bet == null) {
                        hashMap[responseElem.game.id] = listOfBookmakerValues
                    }else {
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
        }
        return hashMap
    }

    fun getCurrentUTC(): String? {
        val time = Calendar.getInstance().time
        val outputFmt = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        outputFmt.timeZone = TimeZone.getTimeZone("UTC")
        return outputFmt.format(time)
    }
}