package com.rafeng.bakery.improve.business.model

data class Order(
    val sellItems: List<SellItem>,
    val total: Double
)