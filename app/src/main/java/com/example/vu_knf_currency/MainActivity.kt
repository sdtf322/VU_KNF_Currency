package com.example.vu_knf_currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vu_knf_currency.data.CurrencyRepositoryImpl
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {


    private val currencyRepositoryImpl:
            CurrencyRepositoryImpl by lazy { CurrencyRepositoryImpl() }
    private val currencyViewModel:
            CurrencyViewModel by lazy { CurrencyViewModel(currencyRepositoryImpl) }
    private val currencyAdapter:
            CurrencyAdapter by lazy { CurrencyAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvMain)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            adapter = currencyAdapter
        }

        currencyViewModel.getLiveData().observe(this) {
            currencyAdapter.setCurrencyList(it)
        }

//        lifecycleScope.launch(Dispatchers.IO) {
//            currencyViewModel.getCurrencies()
//        }

        runBlocking {
            currencyViewModel.getCurrencies()
        }


    }

}