package com.example.thesport.domain.model

data class Season(
    //year
    val season: Int,
    //current or not
    val current: Boolean,
    //start date
    val start: String,
    //end date
    val end: String,
)