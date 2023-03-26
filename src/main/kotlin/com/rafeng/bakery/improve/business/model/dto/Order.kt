package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.model.SellItem
import java.time.LocalDateTime

enum class PaymentType {
    CASH, CARD, ONLINE_WALLET
}

/**
 * This class describes and oder made by a customer
 */
data class Order(
    val sellItems: MutableList<SellItem>,
    var total: Double,
    val createdDateAndTime: LocalDateTime,
    val discountAmount: Double,
    val salesperson: Worker,
    val paymentType: PaymentType
)

data class Worker(
    val name: String,
    val lastname: String,
    val position: Position
)

enum class Position {
    SALESPERSON, MANAGER, BAKER
}

