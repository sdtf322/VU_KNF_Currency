package com.example.vu_knf_currency

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.vu_knf_currency.databinding.ItemCurrencyRateBinding
import com.example.vu_knf_currency.models.CurrencyModel

class CurrencyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    class MyViewHolder(private val binding: ItemCurrencyRateBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(currencyModel: CurrencyModel) {
            binding.tvCurrencyName.text = currencyModel.currencyName
            binding.tvCurrencyRate.text = currencyModel.currencyRate
            binding.tvCurrencyCode.text = currencyModel.currencyCode
        }
    }
}