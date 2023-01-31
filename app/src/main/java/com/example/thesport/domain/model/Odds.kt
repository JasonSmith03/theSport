package com.example.thesport.domain.model

data class Odds(
    val get: String,
    val parameters: OddsParameters,
    val errors: List<Any>,
    val result: Int,
    val response: MutableList<OddsResponse>,
)
