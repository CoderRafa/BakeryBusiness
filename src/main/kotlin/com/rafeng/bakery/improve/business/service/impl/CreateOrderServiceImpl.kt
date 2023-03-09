package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Item
import com.rafeng.bakery.improve.business.model.Order
import com.rafeng.bakery.improve.business.model.SellItem
import com.rafeng.bakery.improve.business.service.CreateOrderService
import com.rafeng.bakery.improve.business.service.PriceService
import java.time.LocalDateTime
import kotlin.math.abs

/**
 * This class can creates an order.
 * This class can add an item to an order.
 * This class can delete an item from an order.
 */
class CreateOrderServiceImpl(private val priceService: PriceService) : CreateOrderService {
    /**
     * This function can create a new order from an item and its amount
     */
    override fun createNewOrder(item: Item, amount: Int): Order {

        val price = priceService.findPriceBy(item.recipe)

        return Order(
            mutableListOf(
                SellItem(
                    item,
                    price!!,
//                    item.createDate.plusDays(item.recipe.expirationPeriod.toLong()),
                    amount
                )
            ), price * amount
        )
    }

    /**
     * This function can create a new order from a list of sellItems.
     */
    override fun createNewOrder(sellItems: Set<SellItem>): Order {
        return Order(
            sellItems.toMutableList(),
            countTotal(sellItems)
        )
    }

    /**
     * This function can count the total price af a group of sellItems passed to it as an argument.
     */
    private fun countTotal(sellItems: Set<SellItem>): Double {
        return sellItems.sumOf { it.price * it.amount }
    }

    /**
     * This function can add an item to an existing order in progress.
     */
    override fun addItemTo(item: Item, order: Order, amount: Int): Order {

        val price = priceService.findPriceBy(item.recipe)!!
        var isSellItemExist = false
        val sellItem = order
            .sellItems
            .firstOrNull { it.item == item }
            ?.also {
                isSellItemExist = true
            } ?: SellItem(item, price, 0, LocalDateTime.now().plusDays(item.recipe.expirationPeriod.toLong()))
        if (!isSellItemExist && amount > 0) {
            sellItem.amount = amount
            order.sellItems.add(sellItem)
        } else if (isSellItemExist && amount < 0 && sellItem.amount >= abs(amount)) {
            sellItem.amount += amount
        } else if ( isSellItemExist && amount < 0 && sellItem.amount <= abs(amount)) {
            println("Subtracted amount can't be more than the existing amount")
        } else if (isSellItemExist && amount > 0) {
            sellItem.amount += amount
        }
        order.total += price * amount

        return order
    }

    /**
     * This function can delete an item from an order.
     */
    override fun delete(order: Order, item: Item) {
        val itemAmount: Int = order.sellItems.filter { it.item.name == item.name }[0].amount
        order.total -= priceService.findPriceBy(item.recipe)!! * itemAmount
        order.sellItems.removeIf { it.item == item }
    }
}
