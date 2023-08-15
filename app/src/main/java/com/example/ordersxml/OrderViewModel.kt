package com.example.ordersxml

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.Product

data class OrderViewModel(
    val address: String,
    val phoneNumber: String,
    val recipient: String,
    val comment: String,
    val numberAndData: String,
    val deliverySpot: String,
    val boxNumber: String,
    val paymentType: String,
    val delivery: Boolean,
) : ViewModel() {
    private val _totalAmount = MutableLiveData<String>()
    val totalAmount: LiveData<String>
        get() = _totalAmount

    fun calculateTotalAmount(products: List<Product>): String {
        var totalAmount = 0.0
        for (product in products) {
            val amount = product.totalSum.substringAfter("₴").trim().toDouble()
            val quantity = product.quantity.substringBefore(" ").toInt()
            totalAmount += amount * quantity
        }
        return "₴ ${String.format("%.2f", totalAmount)}"
    }

    fun setTotalAmount(products: List<Product>) {
        val calculatedTotalAmount = calculateTotalAmount(products)
        _totalAmount.value = calculatedTotalAmount
    }
}