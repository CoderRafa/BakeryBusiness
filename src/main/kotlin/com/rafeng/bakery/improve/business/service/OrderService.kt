package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.controller.ItemWithAmountRequest
import com.rafeng.bakery.improve.business.model.SellItem
import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.Order
import com.rafeng.bakery.improve.business.model.dto.PaymentType
import com.rafeng.bakery.improve.business.model.dto.Worker
import java.time.LocalDateTime
import java.util.*

/**
 * This interface works with orders.
 * The interface can create a new order.
 * The interface can delete an order.
 */
interface OrderService {
    /**
     * This function creates a new order.
     * @param item - Which item we need to create an order with.
     * @param amount - How many items we want to add to an order.
     */
    fun createNewOrder(item: Item,
                       amount: Int,
                       createdDateAndTime: LocalDateTime,
                       discountAmount: Double,
                       salesperson: Worker,
                       paymentType: PaymentType
    ): Order  // 1) First ordered element: I wanna this bun

    /**
     * This function creates a new order from a given list of sell items.
     * @param sellItems - The list of sell items we have to create an order with.
     */
    fun createNewOrder(
        sellItems: Set<SellItem>,
        createdDateAndTime: LocalDateTime,
        discountAmount: Double,
        salesperson: Worker,
        paymentType: PaymentType
        ): Order  // 3) Transfer SellItem to a new order

    /**
     * This function adds an item to an existing order in progress.
     * @param item - The item we want to add to an order.
     * @param item - The item we want to add to an order
     * @param amount - Haw many of these items we would like to add to the order.
     */
    fun addItemWithAmountOrModify(
        uuid: String,
        itemWithAmountRequest: ItemWithAmountRequest
    ): Order // 2) Oh I wanna this cake too and then I wanna a tea

    /**
     * This function deletes an item from an existing order in progress.
     * @param order - From which order we would like to delete this item.
     * @param item - Which item we would like to delete.
     */
    fun deleteItemFromOrder(orderId: String, itemId: String)

    fun deleteOrder(orderId: String)

    fun getAll(): List<Order>
}