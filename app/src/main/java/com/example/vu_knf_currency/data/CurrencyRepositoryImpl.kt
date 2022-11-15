package com.example.vu_knf_currency.data

import com.example.vu_knf_currency.data.network.RetrofitInstance
import com.example.vu_knf_currency.domain.CurrencyRepository
import com.example.vu_knf_currency.models.CurrencyResponse
import com.example.vu_knf_currency.models.Rates
import retrofit2.Call

class CurrencyRepositoryImpl : CurrencyRepository {

    override suspend fun getCurrencyData(): CurrencyResponse {

        val response = RetrofitInstance.api.getCurrencyInfo()

        return response.body()!!
    }

    override suspend fun getCurrencyRates(): Rates {

        val response = getCurrencyData()

        return response.rates
    }

}