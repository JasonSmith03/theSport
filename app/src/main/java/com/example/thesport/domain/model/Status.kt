package com.example.thesport.domain.model

data class Status(
    val errors: List<Any>,
    val `get`: String,
    val parameters: List<Any>,
    val response: ResponseX,
    val results: Int
)