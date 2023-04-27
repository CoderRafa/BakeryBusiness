package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.model.controller.ItemWithAmountRequest
import com.rafeng.bakery.improve.business.repository.impl.OrderRepository
import com.rafeng.bakery.improve.business.service.PriceService
import com.rafeng.bakery.improve.business.service.impl.OrderServiceImpl
import com.rafeng.bakery.improve.business.util.createRandomItemByRecipe
import com.rafeng.bakery.improve.business.util.createRandomOrder
import com.rafeng.bakery.improve.business.util.createRandomOrderWithSellitems
import com.rafeng.bakery.improve.business.util.createRecipe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class OrderKtTest {
    @Mock
    private lateinit var priceService: PriceService

    @Mock
    private lateinit var orderRepository: OrderRepository

    @InjectMocks
    private lateinit var orderService: OrderServiceImpl
    private val recipe = Recipe("test", "super test", 2, 2.15)

    @BeforeEach
    fun setUp() {
        orderService = OrderServiceImpl(priceService, orderRepository)
    }

    @Test
    fun `Happy pass - updateTotal updates the value of total`() {
        doReturn(10.0).`when`(priceService).findPriceBy(recipe)

        val order = createRandomOrderWithSellitems()
        val item = order.sellItems[0].item

        `when`(orderRepository.getAll()).thenReturn(mutableListOf(order))

        val adjustedOrder = orderService.addItemWithAmount(order.id, ItemWithAmountRequest(item, 2))
        adjustedOrder.updateTotal()
        assertEquals(2, adjustedOrder.sellItems[0].amount)

    }

    @Test
    fun addOrModifySellItem() {
        val order = createRandomOrder()
        val item = createRandomItemByRecipe(createRecipe())
        order.addOrModifySellItem(12.0, ItemWithAmountRequest(item, 3))
        Assertions.assertThat(order.sellItems.map { it.item }).contains(item)

    }
}