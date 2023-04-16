package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.SellItem
import com.rafeng.bakery.improve.business.model.controller.ItemWithAmountRequest
import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.Order
import com.rafeng.bakery.improve.business.model.dto.PaymentType
import com.rafeng.bakery.improve.business.model.dto.Worker
import com.rafeng.bakery.improve.business.model.dto.addOrModifySellItem
import com.rafeng.bakery.improve.business.repository.impl.OrderRepository
import com.rafeng.bakery.improve.business.service.OrderService
import com.rafeng.bakery.improve.business.service.PriceService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

/**
 * This class can creates an order.
 * This class can add an item to an order.
 * This class can delete an item from an order.
 */
@Service
class OrderServiceImpl(
    private val priceService: PriceService,
    private val orderRepository: OrderRepository
) : OrderService {

    /**
     * This function can create a new order from an item and its amount
     */
    override fun createNewOrder(
        item: Item,
        amount: Int,
        createdDateAndTime: LocalDateTime,
        discountAmount: Double,
        salesperson: Worker,
        paymentType: PaymentType
    ): Order {

        val price = priceService.findPriceBy(item.recipe)

        val order = Order(
            mutableListOf(
                SellItem(
                    item,
                    price!!,
//                    item.createDate.plusDays(item.recipe.expirationPeriod.toLong()),
                    amount
                )
            ), price * amount,
            createdDateAndTime,
            discountAmount,
            salesperson,
            paymentType
        )

        orderRepository.save(order)

        return order
    }


    /**
     * This function can create a new order from a list of sellItems.
     */
    override fun createNewOrder(
        sellItems: Set<SellItem>,
        createdDateAndTime: LocalDateTime,
        discountAmount: Double,
        salesperson: Worker,
        paymentType: PaymentType
    ): Order {
        return Order(
            sellItems.toMutableList(),
            countTotal(sellItems),
            createdDateAndTime,
            discountAmount,
            salesperson,
            paymentType
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
    override fun addItemWithAmount(uuid: UUID, itemWithAmountRequest: ItemWithAmountRequest): Order {
        val order = getOrderByUuid(uuid)
        order.addOrModifySellItem(priceService.findPriceBy(itemWithAmountRequest.item.recipe)!!, itemWithAmountRequest)
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

    override fun getAll(): List<Order> = orderRepository.getAll().toList()

    fun getOrderByUuid(uuid: UUID) = orderRepository.getAll().first { it.id == uuid }
}
