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
                currencyName = "Euro",
                currencyCode = "EUR",
                currencyRate = rates.EUR.toString()
            )

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = "Japanese yen",
                currencyCode = "JPY",
                currencyRate = rates.JPY.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = "Sterling",
                currencyCode = "GBP",
                currencyRate = rates.GBP.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = "Renminbi",
                currencyCode = "CNY",
                currencyRate = rates.CNY.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = "Australian dollar",
                currencyCode = "AUD",
                currencyRate = rates.AUD.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = "Canadian dollar",
                currencyCode = "CAD",
                currencyRate = rates.CAD.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = "Swiss franc",
                currencyCode = "CHF",
                currencyRate = rates.CHF.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = "Singapore dollar",
                currencyCode = "SGD",
                currencyRate = rates.SGD.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = "Swedish krona",
                currencyCode = "SEK",
                currencyRate = rates.SEK.toString())

            currencyModelList.add(currencyModel)

            currencyModel = CurrencyModel(
                currencyName = "Polish zloty",
                currencyCode = "PLN",
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
}
