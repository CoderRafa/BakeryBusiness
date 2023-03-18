package com.rafeng.bakery.improve.business.model

import java.time.LocalDateTime

/**
 * This class describes an item that can be sold in the bakery
 */
data class SellItem(
    val item: Item,
    val price: Double,
    var amount: Int
) {
    var expirationDate: LocalDateTime = LocalDateTime.now()

    constructor(
        item: Item,
        price: Double,
        amount: Int,
        expirationDate: LocalDateTime = LocalDateTime.now().plusDays(item.recipe.expirationPeriod.toLong())
    ) : this (
        item, price, amount
    ) {
        this.expirationDate = expirationDate
    }
}