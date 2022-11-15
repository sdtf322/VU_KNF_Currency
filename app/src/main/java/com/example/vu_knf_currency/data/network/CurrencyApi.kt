package com.example.vu_knf_currency.data.network

import com.example.vu_knf_currency.models.CurrencyResponse
import com.example.vu_knf_currency.models.Rates
import retrofit2.http.GET

interface CurrencyApi {

    @GET("/latest?base=usd")

    suspend fun getCurrencyInfo() : CurrencyResponse

    suspend fun getCurrencyRates() : Rates

}