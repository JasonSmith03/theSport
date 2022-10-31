package com.example.thesport.data.repository

import com.example.thesport.domain.model.League
import com.example.thesport.domain.model.Status
import com.example.thesport.domain.repository.SportRepository

class SportRepositoryImpl(

): SportRepository {
    override suspend fun getApiStatus(): Status {
        TODO("Not yet implemented")
    }

    override suspend fun getLeague(leagueId: Int): League {
        TODO("Not yet implemented")
    }

}