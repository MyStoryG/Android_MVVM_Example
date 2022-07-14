package com.mvvm.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvm.example.model.Americano
import com.mvvm.example.model.Beverage
import com.mvvm.example.model.TotalPrice

class OrderViewModel : ViewModel() {
    val americanoQty: MutableLiveData<String> = MutableLiveData("0")
    val totalPrice: MutableLiveData<String> = MutableLiveData("0")
    private val menuModel: Beverage = Americano()
    private var totalModel: TotalPrice = TotalPrice()

    fun delAmericano() {
        menuModel.delete()
        americanoQty.value = menuModel.quantity.toString()
        updateTotalPriceSubtraction(menuModel.price)
    }

    open fun addAmericano() {
        menuModel.add()
        americanoQty.value = menuModel.quantity.toString()
        updateTotalPriceAddition(menuModel.price)
    }

    private fun updateTotalPriceSubtraction(price: Int) {
        totalModel.decreaseTotalPrice(price)
        totalPrice.value = totalModel.totalPrice.toString()
    }

    private fun updateTotalPriceAddition(price: Int) {
        totalModel.increaseTotalPrice(price)
        totalPrice.value = totalModel.totalPrice.toString()
    }
}