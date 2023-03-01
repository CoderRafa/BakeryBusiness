package com.rafeng.bakery.improve.business.model

import java.time.LocalDateTime

data class SellItem(
    val item: Item,
    val price: Double,
    val expirationDate: LocalDateTime,
    var amount: Int
)