package com.rafeng.bakery.improve.business.service.general

import com.rafeng.bakery.improve.business.common.generateUniqueStringIdentifier
import com.rafeng.bakery.improve.business.controller.ItemWithAmountRequest
import com.rafeng.bakery.improve.business.model.SellItem
import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.Order
import com.rafeng.bakery.improve.business.model.dto.PaymentType
import com.rafeng.bakery.improve.business.model.dto.Worker
import com.rafeng.bakery.improve.business.model.dto.addOrModifySellItem
import com.rafeng.bakery.improve.business.model.dto.updateTotal
import com.rafeng.bakery.improve.business.repository.impl.OrderRepository
import com.rafeng.bakery.improve.business.service.OrderService
import com.rafeng.bakery.improve.business.service.PriceService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

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

        val price = priceService.findPriceBy(item.recipe.id!!)

        val order = Order(
            generateUniqueStringIdentifier(),
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
            generateUniqueStringIdentifier(),
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
    override fun addItemWithAmountOrModify(uuid: String, itemWithAmountRequest: ItemWithAmountRequest): Order {
        val order = getOrderByUuid(uuid)
        order.addOrModifySellItem(
            priceService.findPriceBy(itemWithAmountRequest.item.recipe.id!!)!!,
            itemWithAmountRequest
        )
        return order
    }

    /**
     * This function can delete an item from an order.
     */
    override fun deleteItemFromOrder(orderId: String, itemId: String) {
        val order: Order = orderRepository.findById(orderId) ?: return
        order.sellItems.removeIf { it.item.id == itemId }
        order.updateTotal()
    }

    override fun deleteOrder(orderId: String) {
        val order: Order = orderRepository.findById(orderId) ?: return
        orderRepository.delete(order)
    }

    override fun getAll(): List<Order> = orderRepository.getAll().toList()

    fun getOrderByUuid(uuid: String) = orderRepository.getAll().first { it.id == uuid.toString() }
}
