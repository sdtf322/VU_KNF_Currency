package com.example.vu_knf_currency.data

import com.example.vu_knf_currency.domain.CurrencyRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CurrencyRepositoryImplTest {

    private val currencyRepository : CurrencyRepository = CurrencyRepositoryImpl()

    @Test
    fun whenApiCallWasSuccessful() {
        runBlocking {
            val expectedResult = true

            val actualResult = currencyRepository.
            getCurrencyData().success

            assertEquals(expectedResult, actualResult)
        }
    }

    @Test
    fun whenEuroCurrencyRateValueIsNotZero() {

        runBlocking {
            val rates = currencyRepository.getCurrencyRates()
            val euroRate = rates.EUR!!

            assertNotEquals(0, euroRate)
        }
    }

    @Test
    fun whenUsdRateEqualsToOne() {

        runBlocking {
            val expectedResult = 1
            val rates = currencyRepository.getCurrencyRates()
            val usdRate = rates.USD

            assertEquals(expectedResult, usdRate)
        }
    }

    @Test
    fun whenYenCurrencyRateValueIsNotZero() {

        runBlocking {
            val rates = currencyRepository.getCurrencyRates()
            val yenRate = rates.JPY!!

            assertNotEquals(0, yenRate)
        }
    }

    @Test
    fun whenCurrencyBaseSetToUSD() {

        runBlocking {

            val expectedBase = "USD"
            val actualBase = currencyRepository.getCurrencyData().base

            assertEquals(expectedBase, actualBase)
        }
    }

}