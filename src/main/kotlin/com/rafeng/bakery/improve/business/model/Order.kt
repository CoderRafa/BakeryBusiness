package com.rafeng.bakery.improve.business.model

data class Order(
    val sellItems: MutableList<SellItem>,
    var total: Double
)