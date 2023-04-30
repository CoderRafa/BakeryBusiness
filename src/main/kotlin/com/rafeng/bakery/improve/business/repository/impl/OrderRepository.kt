package com.rafeng.bakery.improve.business.repository.impl

import com.rafeng.bakery.improve.business.model.dto.Order
import org.springframework.stereotype.Component

/**
 * This class describes orders that has been done so far
 */
@Component
class OrderRepository(
    private val orders: MutableList<Order> = mutableListOf()
) : DefaultRepositoryImpl<Order>(orders) {
    fun findById(orderId: String) = orders.firstOrNull { it.id == orderId }
}