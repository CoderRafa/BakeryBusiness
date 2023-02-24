package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Item
import com.rafeng.bakery.improve.business.model.Order
import com.rafeng.bakery.improve.business.model.SellItem
import com.rafeng.bakery.improve.business.service.CreateOrderService
import com.rafeng.bakery.improve.business.service.PriceService

class CreateOrderServiceImpl(private val priceService: PriceService) : CreateOrderService {
    override fun createNewOrder(item: Item, amount: Int): Order {
        return Order(
            listOf(
                SellItem(
                    item,
                    priceService.findPriceBy(item.recipe)!!,
                    item.createDate.plusDays(item.recipe.expirationPeriod.toLong()),
                    amount
                )
            ), priceService.findPriceBy(item.recipe)!! * amount)
    }

    override fun createNewOrder(sellItems: Set<SellItem>): Order {
        TODO("Not yet implemented")
    }

    override fun addItemTo(item: Item, order: Order): Order {
        TODO("Not yet implemented")
    }

    override fun delete(order: Order) {
        TODO("Not yet implemented")
    }
}