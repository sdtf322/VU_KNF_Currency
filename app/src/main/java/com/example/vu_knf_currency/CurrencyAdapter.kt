package com.example.vu_knf_currency

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vu_knf_currency.databinding.ItemCurrencyRateBinding
import com.example.vu_knf_currency.models.CurrencyModel

class CurrencyAdapter : RecyclerView.Adapter<CurrencyViewHolder.MyViewHolder>() {

    private var currencyList = ArrayList<CurrencyModel>()

    fun setCurrencyList(currencyList : ArrayList<CurrencyModel>) {
        this.currencyList = currencyList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CurrencyViewHolder.MyViewHolder {
        return CurrencyViewHolder.MyViewHolder(
            ItemCurrencyRateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder.MyViewHolder, position: Int) {
        holder.bind(currencyList[position])
    }

    override fun getItemCount(): Int = currencyList.size
}