package com.example.thesport.domain.model

data class Response(
    val id: Int,
    //league name
    val name: String,
    //The type of the league
    val type: String,
    //league logo
    val logo: String,
    val country: Country,
    val seasons: List<Season>,
)