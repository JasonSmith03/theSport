package com.example.thesport.domain.model

data class League(
    val get: String,
    val parameters: Parameters,
    val errors: List<Any>,
    val results: Int,
    val response: List<Response>,
)