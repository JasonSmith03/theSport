package com.example.thesport.domain.model

data class Bets(
    val id: Int,
    val name: String,
    val values: MutableList<Values>

)
