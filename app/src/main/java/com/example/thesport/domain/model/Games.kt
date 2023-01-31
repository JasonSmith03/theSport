package com.example.thesport.domain.model

data class Games(
    val get: String,
    val parameters: GameParameters,
    val errors: List<Any>,
    val results: Int,
    val response: MutableList<GameResponse>,
)

