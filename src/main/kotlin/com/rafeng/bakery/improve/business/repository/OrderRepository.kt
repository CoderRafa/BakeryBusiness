package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.dto.Order

/**
 * This class describes orders that has been done so far
 */
class OrderRepository (
    private val orders: MutableList<Order> = mutableListOf()
) {
    /**
     * This function adds an order to the list of existing orders
     */
    fun save(order: Order): Boolean {
        return this.orders.add(order)
    }
    /**
     * This function deletes an order from the list of existing orders
     */
    fun delete(order: Order): Boolean {
        return this.orders.remove(order)
    }
    /**
     * This function gets all the existing orders
     */
    fun getAll(): MutableList<Order> {
        return this.orders
    }
}