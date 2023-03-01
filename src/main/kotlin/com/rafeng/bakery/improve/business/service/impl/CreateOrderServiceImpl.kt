package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Item
import com.rafeng.bakery.improve.business.model.Order
import com.rafeng.bakery.improve.business.model.SellItem
import com.rafeng.bakery.improve.business.service.CreateOrderService
import com.rafeng.bakery.improve.business.service.PriceService

/**
 * This class can creates an order.
 * This class can add an item to an order.
 * This class can delete an item from an order.
 */
class CreateOrderServiceImpl(private val priceService: PriceService) : CreateOrderService {
    override fun createNewOrder(item: Item, amount: Int): Order {
        return Order(
            mutableListOf(
                SellItem(
                    item,
                    priceService.findPriceBy(item.recipe)!!,
                    item.createDate.plusDays(item.recipe.expirationPeriod.toLong()),
                    amount
                )
            ), priceService.findPriceBy(item.recipe)!! * amount
        )
    }

    override fun createNewOrder(sellItems: Set<SellItem>): Order {
        return Order(
            sellItems.toMutableList(),
            countTotal(sellItems)
        )
    }

    private fun countTotal(sellItems: Set<SellItem>): Double {
        return sellItems.sumOf { it.price * it.amount }
    }

    override fun addItemTo(item: Item, order: Order, amount: Int): Order {
        val price = priceService.findPriceBy(item.recipe)!!
        val sellItem = order.sellItems.firstOrNull { it.item == item }?.let { it.amount = it.amount + amount }
        if (sellItem == null) {
            order.sellItems.add(
                SellItem(
                    item,
                    price,
                    item.createDate.plusDays(item.recipe.expirationPeriod.toLong()),
                    amount
                )
            )
        }
        order.total += price * amount

        return order
    }

    override fun delete(order: Order, item: Item) {
        val itemAmount: Int = order.sellItems.filter { it.item.name == item.name }[0].amount
        order.total -= priceService.findPriceBy(item.recipe)!! * itemAmount
        order.sellItems.removeIf { it.item == item }
    }
}
