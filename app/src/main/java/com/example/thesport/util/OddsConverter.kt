package com.example.thesport.util

object OddsConverter {
    fun decimalToAmerican(decimal: Double): Double {
        val result =  if (decimal > 2.0) {
            (decimal - 1.0) * 100.0
        } else {
            -100.0 / (decimal - 1.0)
        }
        return Math.round(result * 10.0) / 10.0
    }
}
