package com.example.vu_knf_currency.models

data class CurrencyResponse (
    val base: String,
    val rates: Rates,
    val date: String,
    val motd: Motd,
    val success: Boolean
)