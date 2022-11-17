package com.example.vu_knf_currency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.vu_knf_currency.data.CurrencyRepositoryImpl
import com.example.vu_knf_currency.models.CurrencyModel
import retrofit2.HttpException
import java.io.IOException

class CurrencyViewModel(private val currencyRepositoryImpl: CurrencyRepositoryImpl) {

    private val mutableCurrencyModelList = MutableLiveData<ArrayList<CurrencyModel>>()

    suspend fun getCurrencies() {
        try {

            val rates = currencyRepositoryImpl.getCurrencyRates()

            val currencyModelList = ArrayList<CurrencyModel>()

            // Select only a few currencies from whole list
            // Since API only provides currency rates,
            // codes and names are hard-coded

            var currencyModel = CurrencyModel(
                currencyName = EURO,
                currencyCode = EURO_CODE,
                currencyRate = rates.EUR.toString()
            )

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = JAPANESE_YEN,
                currencyCode = JAPANESE_YEN_CODE,
                currencyRate = rates.JPY.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = STERLING,
                currencyCode = STERLING_CODE,
                currencyRate = rates.GBP.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = RENMINBI,
                currencyCode = RENMINBI_CODE,
                currencyRate = rates.CNY.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = AUSTR_DOLLAR,
                currencyCode = AUSTR_DOLLAR_CODE,
                currencyRate = rates.AUD.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = CANAD_DOLLAR,
                currencyCode = CANAD_DOLLAR_CODE,
                currencyRate = rates.CAD.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = SWISS_FRANC,
                currencyCode = SWISS_FRANC_CODE,
                currencyRate = rates.CHF.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName =  SING_DOLLAR,
                currencyCode = SING_DOLLAR_CODE,
                currencyRate = rates.SGD.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = SWEDISH_KRONA,
                currencyCode = SWEDISH_KRONA_CODE,
                currencyRate = rates.SEK.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = POLISH_ZLOTY,
                currencyCode = POLISH_ZLOTY_CODE,
                currencyRate = rates.PLN.toString())

            currencyModelList.add(currencyModel)

            mutableCurrencyModelList.postValue(currencyModelList)

        } catch (e: IOException) {
            println(e.message)
        } catch (e: HttpException) {
            println(e.message)
        }
    }

    fun getLiveData() : LiveData<ArrayList<CurrencyModel>> {
        return mutableCurrencyModelList
    }

    companion object {
        private const val EURO = "Euro"
        private const val EURO_CODE = "EUR"
        private const val JAPANESE_YEN = "Japanese Yen"
        private const val JAPANESE_YEN_CODE = "JPY"
        private const val STERLING = "Sterling"
        private const val STERLING_CODE = "GBP"
        private const val RENMINBI = "Renminbi"
        private const val RENMINBI_CODE = "CNY"
        private const val AUSTR_DOLLAR = "Australian Dollar"
        private const val AUSTR_DOLLAR_CODE = "AUD"
        private const val CANAD_DOLLAR = "Canadian Dollar"
        private const val CANAD_DOLLAR_CODE = "CAD"
        private const val SWISS_FRANC = "Swiss Franc"
        private const val SWISS_FRANC_CODE = "CHF"
        private const val SING_DOLLAR = "Singapore Dollar"
        private const val SING_DOLLAR_CODE = "SGD"
        private const val SWEDISH_KRONA = "Swedish Krona"
        private const val SWEDISH_KRONA_CODE = "SEK"
        private const val POLISH_ZLOTY = "Polish Zloty"
        private const val POLISH_ZLOTY_CODE = "PLN"


    }
}
