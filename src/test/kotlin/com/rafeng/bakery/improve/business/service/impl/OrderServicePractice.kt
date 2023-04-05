package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.*
import com.rafeng.bakery.improve.business.model.dto.*
import com.rafeng.bakery.improve.business.service.OrderService
import com.rafeng.bakery.improve.business.service.PriceService
import com.rafeng.bakery.improve.business.util.createRandomItemByRecipe
import com.rafeng.bakery.improve.business.util.createRecipe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime

@ExtendWith(MockitoExtension::class)
class OrderServicePractice {

    @Mock
    private lateinit var priceService: PriceService

    private lateinit var orderService: OrderService

    private val recipe = createRecipe()

    @BeforeEach
    fun setUp() {
        orderService = OrderServiceImpl(priceService)
    }

    @AfterEach
    fun tearDown() {
        println("We're done")
    }

    @Test
    fun `Happy pass - create a new order`() {

        `when`(priceService.findPriceBy(recipe)).thenReturn(10.0)

        val newOrder = createOrder(
            recipe,
            1,
            LocalDateTime.now(),
            5.0,
            Worker("Lena", "Trofimova", Position.SALESPERSON),
            PaymentType.CASH
            )
        assertThat(newOrder).isNotNull
        assertThat(newOrder).hasNoNullFieldsOrProperties()
        assertThat(newOrder.sellItems[0].item.recipe).isEqualTo(recipe)
        assertThat(newOrder.sellItems[0].amount).isEqualTo(1)
        assertThat(newOrder.total).isEqualTo(10.0)

        verify(priceService, times(1)).findPriceBy(recipe)
    }

    fun createOrder(
        recipe: Recipe,
        amount: Int,
        createdDateAndTime: LocalDateTime,
        discountAmount: Double,
        salesperson: Worker,
        paymentType: PaymentType
        ): Order {

        return orderService.createNewOrder(
            createRandomItemByRecipe(recipe),
            amount,
            createdDateAndTime,
            discountAmount,
            salesperson,
            paymentType
            )

    }


}