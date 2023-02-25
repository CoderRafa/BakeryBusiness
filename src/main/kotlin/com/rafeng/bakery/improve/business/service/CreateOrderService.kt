package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.Item
import com.rafeng.bakery.improve.business.model.Order
import com.rafeng.bakery.improve.business.model.SellItem

/**
 * This interface works with orders.
 * The interface can create a new order.
 * The interface can delete an order.
 */
interface CreateOrderService {
    /**
     * This function creates a new order.
     * @param item - Which item we need to create an order with.
     * @param amount - How many items we want to add to an order.
     */
    fun createNewOrder(item: Item, amount: Int): Order  // 1) First ordered element: I wanna this bun
    fun createNewOrder(sellItems: Set<SellItem>): Order  // 3) Transfer SellItem to a new order
    fun addItemTo(item: Item, order: Order, amount: Int): Order // 2) Oh I wanna this cake too and then I wanna a tea
    fun delete(order: Order, item: Item)
}