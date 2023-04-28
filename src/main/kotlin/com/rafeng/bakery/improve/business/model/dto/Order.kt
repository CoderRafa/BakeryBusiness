package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.model.SellItem
import com.rafeng.bakery.improve.business.model.controller.ItemWithAmountRequest
import java.time.LocalDateTime
import java.util.*

/**
 * This class describes an oder made by a customer
 */
data class Order(
    val id: UUID = UUID.randomUUID(),
    val sellItems: MutableList<SellItem>,
    var total: Double,
    val createdDateAndTime: LocalDateTime,
    var discountAmount: Double,
    var salesperson: Worker,
    val paymentType: PaymentType
)

fun Order.updateTotal() = this.let {
    it.total = it.sellItems.fold(0.0) { acc: Double, sellItem: SellItem -> acc + sellItem.amount * sellItem.price }
}

fun Order.addOrModifySellItem(price: Double, itemWithAmountRequest: ItemWithAmountRequest) =
    sellItems
        .firstOrNull { it.item == itemWithAmountRequest.item }
        ?.apply { this.amount = itemWithAmountRequest.amount } ?: sellItems.add(
        SellItem(
            itemWithAmountRequest.item,
            price,
            itemWithAmountRequest.amount
        )
    )
