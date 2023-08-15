package com.example.ordersxml

import androidx.lifecycle.ViewModel

data class OrderViewModel(
    val address: String,
    val phoneNumber: String,
    val recipient: String,
    val comment: String,
    val numberAndData: String,
    val deliverySpot: String,
    val boxNumber: String,
    val paymentType: String,
    val delivery: Boolean
) : ViewModel() {

}