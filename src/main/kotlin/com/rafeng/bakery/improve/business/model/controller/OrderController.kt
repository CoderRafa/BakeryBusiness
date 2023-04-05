package com.rafeng.bakery.improve.business.model.controller

import com.rafeng.bakery.improve.business.model.SellItem
import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.Order
import com.rafeng.bakery.improve.business.model.dto.PaymentType
import com.rafeng.bakery.improve.business.model.dto.Worker
import com.rafeng.bakery.improve.business.service.OrderService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/order")
class OrderController(val orderService: OrderService) {

    @PostMapping ("/basic")
    fun createNewOrder(@RequestBody order: OrderElementsRequest) {
        orderService.createNewOrder(
            order.item,
            order.amount,
            order.createdDateAndTime,
            order.discountAmount,
            order.salesperson,
            order.paymentType
        )
    }

    @PostMapping("/sell-item")
    fun createNewOrderFromSellItems(@RequestBody order: OrderFromSellItemsElementsRequest) {
        orderService.createNewOrder(
            order.sellItem,
            order.createdDateAndTime,
            order.discountAmount,
            order.salesperson,
            order.paymentType
        )
    }

    @PutMapping
    fun addItem(item: Item, order: Order, amount: Int) {
        orderService.addItemTo(
            item,
            order,
            amount
        )
    }

    @DeleteMapping
    fun deleteItem(order: Order, item: Item) {
        orderService.delete(
            order,
            item
        )
    }


}

class OrderElementsRequest(
    val item: Item,
    val amount: Int,
    val createdDateAndTime: LocalDateTime,
    val discountAmount: Double,
    val salesperson: Worker,
    val paymentType: PaymentType
)

class OrderFromSellItemsElementsRequest(
    val sellItem: Set<SellItem>,
    val createdDateAndTime: LocalDateTime,
    val discountAmount: Double,
    val salesperson: Worker,
    val paymentType: PaymentType
)
