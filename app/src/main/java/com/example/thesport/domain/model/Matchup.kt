package com.example.thesport.domain.model

data class Matchup(
    val matchupId: Int,
    val homeLogo: String,
    val homeName: String,
    val homeScore: String,
    val awayLogo: String,
    val awayName: String,
    val awayScore: String,
)
