package com.example.vu_knf_currency.domain

import com.example.vu_knf_currency.models.CurrencyResponse
import com.example.vu_knf_currency.models.Rates

interface CurrencyRepository {

    suspend fun getCurrencyData() : CurrencyResponse

    suspend fun getCurrencyRates() : Rates

}