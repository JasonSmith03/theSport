package com.example.thesport.domain.model

data class GameResponse(
    val id: Int,
    val date: String,
    val time: String,
    val timestamp: Long,
    val timeZone: String,
    val week: String?,
    val timer: String?,
    val status: GameStatus,
    val country: Country,
    val league: GameLeague,
    val teams: GameTeams,
    val scores: GameScore,
    val periods: GamePeriods,
    val events: Boolean
)
