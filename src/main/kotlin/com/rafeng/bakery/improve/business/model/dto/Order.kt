package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.model.SellItem
import java.time.LocalDateTime

/**
 * This class describes an oder made by a customer
 */
data class Order(
    val sellItems: MutableList<SellItem>,
    var total: Double,
    val createdDateAndTime: LocalDateTime,
    val discountAmount: Double,
    val salesperson: Worker,
    val paymentType: PaymentType
)

/**
 * This class describes a worker of the bakery
 */
data class Worker(
    val name: String,
    val lastname: String,
    val position: Position
)

/**
 * This class describes the work position in the bakery
 */
enum class Position {
    SALESPERSON, MANAGER, BAKER
}

/**
 * This class describes the payment methods available for purchasing goods from the bakery
 */
enum class PaymentType {
    CASH, CARD, ONLINE_WALLET
}


