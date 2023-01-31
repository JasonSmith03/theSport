package com.example.thesport.domain.model

data class OddsResponse(
    val league: OddsLeague,
    val country: Country,
    val game: GameResponse,
    val bookmakers: MutableList<Bookmaker>

)
