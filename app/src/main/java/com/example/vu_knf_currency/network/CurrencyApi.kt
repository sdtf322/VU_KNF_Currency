package com.example.vu_knf_currency.network

import com.example.vu_knf_currency.models.CurrencyResponse
import retrofit2.http.GET

interface CurrencyApi {

    @GET("/latest?base=usd") // List of Race Schedule of Current Season

    suspend fun getCurrencyInfo() : CurrencyResponse
//
//    suspend fun getRaceList() : List<Race>


}