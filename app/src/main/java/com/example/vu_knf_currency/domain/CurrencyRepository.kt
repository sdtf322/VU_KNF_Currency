package com.example.vu_knf_currency.domain

import com.example.vu_knf_currency.models.CurrencyResponse
import retrofit2.Call

interface CurrencyRepository {

    suspend fun getCurrencyData() : CurrencyResponse

}