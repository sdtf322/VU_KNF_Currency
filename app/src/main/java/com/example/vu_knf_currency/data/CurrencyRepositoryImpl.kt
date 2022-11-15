package com.example.vu_knf_currency.data

import com.example.vu_knf_currency.data.network.RetrofitInstance
import com.example.vu_knf_currency.domain.CurrencyRepository
import com.example.vu_knf_currency.models.CurrencyResponse
import retrofit2.Call

class CurrencyRepositoryImpl : CurrencyRepository {

    override suspend fun getCurrencyData(): CurrencyResponse {

        return RetrofitInstance.api.getCurrencyInfo()
    }

}