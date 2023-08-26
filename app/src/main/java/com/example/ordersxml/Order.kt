package com.example.ordersxml

data class Order(
    val id: String,
    val address: String,
    val phoneNumber: String,
    val recipient: String,
    val comment: String,
    val numberAndData: String,
    val deliverySpot: String,
    val boxNumber: String,
    val paymentType: String,
    val delivery: Boolean,
) {
}