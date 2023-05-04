package com.old

import com.rafeng.bakery.improve.business.model.*
import com.rafeng.bakery.improve.business.model.FillingType.*
import com.rafeng.bakery.improve.business.model.ItemSmell.STRONG
import com.rafeng.bakery.improve.business.model.Taste.SWEET
import com.rafeng.bakery.improve.business.model.controller.ItemWithAmountRequest
import com.rafeng.bakery.improve.business.model.dto.*
import com.rafeng.bakery.improve.business.model.dto.Position.SALESPERSON
import com.rafeng.bakery.improve.business.repository.impl.OrderRepository
import com.rafeng.bakery.improve.business.service.PriceService
import com.rafeng.bakery.improve.business.service.impl.OrderServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextInt

@ExtendWith(MockitoExtension::class)
class OrderServiceImplTest {

    @Mock
    private lateinit var priceService: PriceService

    @Mock
    private lateinit var orderRepository: OrderRepository

    @InjectMocks
    private lateinit var orderService: OrderServiceImpl
    private val recipe = Recipe(name = "test", description = "super test", expirationPeriod = 2, cookingTime = 2.15)

    @BeforeEach
    fun setUp() {
        orderService = OrderServiceImpl(priceService, orderRepository)
    }

    @AfterEach
    fun tearDown() {
        println("Test is finished. Lets go and eat :)")
    }

    @Test
    fun `Happy pass - create a new order`() {

        `when`(priceService.findPriceBy(recipe.id)).thenReturn(10.0)

        val newOrder = createOrder(
            recipe,
            1,
            LocalDateTime.now(),
            5.0,
            Worker(name = "Lena", lastname = "Trofimova", position = SALESPERSON),
            PaymentType.CASH
            )
        assertThat(newOrder).isNotNull
        assertThat(newOrder).hasNoNullFieldsOrProperties()
        assertThat(newOrder.sellItems[0].item.recipe).isEqualTo(recipe)
        assertThat(newOrder.sellItems[0].amount).isEqualTo(1)
        assertThat(newOrder.total).isEqualTo(10.0)

        verify(priceService, times(1)).findPriceBy(recipe.id)
    }

    @Test
    fun `Happy pass - add a new item to the existing order`() {
        doReturn(10.0).`when`(priceService).findPriceBy(recipe.id)

        val newOrder = createOrder(
            recipe,
            3,
            LocalDateTime.now(),
            5.0,
            Worker(name = "Lena", lastname = "Trofimova", position = SALESPERSON),
            PaymentType.CASH
        )
        val item = newOrder.sellItems[0].item

        `when`(orderRepository.getAll()).thenReturn(mutableListOf(newOrder))

        val order = orderService.addItemWithAmountOrModify(newOrder.id.toString(), ItemWithAmountRequest(item, 2))

        order.updateTotal()

        assertThat(order.sellItems).size().isEqualTo(1)
        assertThat(order.sellItems).allMatch { it.item.recipe == recipe }
        assertThat(order.sellItems).allMatch { it.amount == 2 }
        assertThat(order.total).isEqualTo(20.0)

        verify(priceService, times(2)).findPriceBy(recipe.id)
    }

    @Test
    fun `Happy pass - create a new order by passing a set of sellItems`() {
        doReturn(10.0).`when`(priceService).findPriceBy(recipe.id)
        val sellItems = mutableSetOf<SellItem>()
        (1..10).forEach {
            sellItems.add(SellItem(createRandomItemByRecipe(recipe),
                priceService.findPriceBy(recipe.id)!!,
                1
            ))}
        assertTrue(sellItems.size > 0)
        assertThat(sellItems.size).isEqualTo(10)
        assertTrue(sellItems.all { it.amount == 1} )
        assertTrue(sellItems.all { it.price == 10.0} )
        assertTrue(sellItems.all { it.item.recipe == recipe})

        verify(priceService, times(10)).findPriceBy(recipe.id)

    }

    @Test
    fun `Negative pass - adding negative amount`() {
        doReturn(10.0).`when`(priceService).findPriceBy(recipe.id)

        val newOrder = createOrder(
            recipe,
            5,
            LocalDateTime.now(),
            5.0,
            Worker(name = "Lena", lastname = "Trofimova", position = SALESPERSON),
            PaymentType.CASH
            )
        val item = newOrder.sellItems[0].item
        `when`(orderRepository.getAll()).thenReturn(mutableListOf(newOrder))
        val order = orderService.addItemWithAmountOrModify(newOrder.id, ItemWithAmountRequest(item, -7))
        assertFalse(order.sellItems[0].amount == -2)

        verify(priceService, times(2)).findPriceBy(recipe.id)
    }

    @Test
    fun `Happy pass - the item is deleted from the selliItems`() {
        doReturn(10.0).`when`(priceService).findPriceBy(recipe.id)
        val sellItems = mutableSetOf<SellItem>()
        (1..10).forEach {
            sellItems.add(SellItem(createRandomItemByRecipe(recipe),
                priceService.findPriceBy(recipe.id)!!,
                1
            ))}
        val order = createOrderFromSellItems(
            sellItems,
            LocalDateTime.now(),
            5.0,
            Worker(name = "Lena", lastname = "Trofimova", position = SALESPERSON),
            PaymentType.CASH
            )

        orderService.deleteItemFromOrder(order.id, sellItems.first().item.id)
        assertEquals(90.0, order.total)
        assertEquals(9, order.sellItems.size)

        verify(priceService, times(11)).findPriceBy(recipe.id)

    }

    fun createOrderFromSellItems(
        sellItems: Set<SellItem>,
        createdDateAndTime: LocalDateTime,
        discountAmount: Double,
        salesperson: Worker,
        paymentType: PaymentType
    ): Order {
        return orderService.createNewOrder(
            sellItems,
            createdDateAndTime,
            discountAmount,
            salesperson,
            paymentType
            )
    }

    private fun createOrder(
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

    fun createRandomItemByRecipe(recipe: Recipe): Item {
        return Item(
            ('a'..'z').take(nextInt(1, 27)).joinToString(""),
            nextDouble(),
            ItemSize.values()[nextInt(0, ItemSize.values().size - 1)],
            STRONG,
            SWEET,
            listOf(ItemFilling(Filling("test", "super test", JAM, SWEET), 10.0)),
            listOf(ItemTopping(Topping("test", "super test", ToppingType.CREAM, SWEET), 10.0)),
            300,
            listOf(),
            false,
            recipe,
            LocalDateTime.now()

        )
    }
}