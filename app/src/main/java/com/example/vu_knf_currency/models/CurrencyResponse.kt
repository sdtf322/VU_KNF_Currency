package com.example.vu_knf_currency.models

data class CurrencyResponse(
    val base: String,
    val date: String,
    val motd: Motd,
    val rates: Rates,
    val success: Boolean
)