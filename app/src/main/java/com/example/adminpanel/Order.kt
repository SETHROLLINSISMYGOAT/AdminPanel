package com.example.adminpanel

data class Order(
    val restaurantName: String,
    val price: String,
    val orderNumber: String,
    val orderDetails: String,
    val status: String,
    val time: String,
    val driverName: String,
    val statusColorRes: Int
)