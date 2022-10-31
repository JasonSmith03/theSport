package com.example.thesport.data.repository

import com.example.thesport.data.remote.SportApi
import com.example.thesport.domain.model.League
import com.example.thesport.domain.model.Status
import com.example.thesport.domain.repository.SportRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SportRepositoryImpl @Inject constructor(
    private val api: SportApi,
): SportRepository {
    override suspend fun getApiStatus(): Status {
        return api.getStatus()
    }

    override suspend fun getLeague(
        leagueId: Int
    ): League {
        return api.getLeagues(leagueId)
    }

}