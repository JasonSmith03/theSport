package com.example.thesport.data.repository

import android.service.autofill.FieldClassification.Match
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.example.thesport.data.remote.SportApi
import com.example.thesport.domain.model.*
import com.example.thesport.domain.repository.SportRepository
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
                    responseElem.teams.home.logo,
                    responseElem.teams.home.name,
                    responseElem.scores.home.toString(),
                    responseElem.teams.away.logo,
                    responseElem.teams.away.name,
                    responseElem.scores.away.toString()
                )
            )
        }
        return matchupList
    }
}