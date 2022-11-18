package com.example.vu_knf_currency.utils

object Validator {

    fun validateCurrency(currency : Double) : Boolean {
        return currency > 0
    }
}