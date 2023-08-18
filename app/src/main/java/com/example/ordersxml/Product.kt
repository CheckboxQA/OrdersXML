package com.example.ordersxml

data class Product(
    val id: String,
    val name: String,
    val barcode: String?,
    val totalSum: String,
    val quantity: String
)
