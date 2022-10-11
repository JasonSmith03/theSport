package com.example.thesport.domain.model

data class Subscription(
    val active: Boolean,
    val end: String,
    val plan: String
)