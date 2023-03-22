package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.model.SellItem

/**
 * This class describes and oder made by a customer
 */
data class Order(
    val sellItems: MutableList<SellItem>,
    var total: Double
)