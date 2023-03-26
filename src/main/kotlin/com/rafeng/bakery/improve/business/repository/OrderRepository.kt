package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.dto.Order

class OrderRepository (
    private val orders: MutableList<Order> = mutableListOf()
) {
    fun save(order: Order): Boolean {
        return this.orders.add(order)
    }

    fun delete(order: Order): Boolean {
        return this.orders.remove(order)
    }

    fun getAll(): MutableList<Order> {
        return this.orders
    }
}