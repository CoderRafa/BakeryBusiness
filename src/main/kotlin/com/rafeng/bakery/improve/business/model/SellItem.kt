package com.rafeng.bakery.improve.business.model

import java.time.LocalDateTime

/**
 * This class describes an item that can be sold in the bakery
 */
data class SellItem(
    val item: Item,
    val price: Double,
    val expirationDate: LocalDateTime,
    var amount: Int
)