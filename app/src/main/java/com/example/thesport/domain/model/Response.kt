package com.example.thesport.domain.model

data class Response(
    val id: Int,
    //league name
    val name: String,
    //The type of the league
    val type: String,
    val seasons: List<Season>,
    val country: Country,
    val logo: String,

)