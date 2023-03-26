package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.dto.Order

data class OrderRepository (
    private val orders: MutableList<Order> = mutableListOf()
)

inline fun OrderRepository.save(order: Order): Boolean {
    return this.orders.add(order)
}

fun OrderRepository.delete(order: Order): Boolean {
    return this.orders.remove(order)
}

fun OrderRepository.getAll(): MutableList<Order> {
    return this.orders
}