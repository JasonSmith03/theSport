package com.example.thesport.domain.model

data class Bookmaker(
    val id: Int,
    val name: String,
    val bet: MutableList<Bets>
)
