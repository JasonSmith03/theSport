package com.example.thesport.domain.repository

import com.example.thesport.domain.model.League
import com.example.thesport.domain.model.Status

interface SportRepository {
    //TODO - implement Resource as part of return values

    suspend fun getApiStatus(): Status

    suspend fun getLeague(
        leagueId: Int,
    ): League
}