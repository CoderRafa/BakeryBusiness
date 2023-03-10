package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.*
import com.rafeng.bakery.improve.business.model.FillingType.*
import com.rafeng.bakery.improve.business.model.ItemSmell.STRONG
import com.rafeng.bakery.improve.business.model.Taste.SWEET
import com.rafeng.bakery.improve.business.service.CreateOrderService
import com.rafeng.bakery.improve.business.service.PriceService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
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
class CreateOrderServiceImplTest {

    @Mock
    private lateinit var priceService: PriceService
    private lateinit var createOrderService: CreateOrderService
    private val recipe = Recipe("test", "super test", 2, 2.15)

    @BeforeEach
    fun setUp() {
        createOrderService = CreateOrderServiceImpl(priceService)
    }

    @AfterEach
    fun tearDown() {
        println("Test is finished. Lets go and eat :)")
    }

    @Test
    fun `Happy pass - create a new order`() {

        `when`(priceService.findPriceBy(recipe)).thenReturn(10.0)

        val newOrder = createOrder(recipe, 1)
        assertThat(newOrder).isNotNull
        assertThat(newOrder).hasNoNullFieldsOrProperties()
        assertThat(newOrder.sellItems[0].item.recipe).isEqualTo(recipe)
        assertThat(newOrder.sellItems[0].amount).isEqualTo(1)
        assertThat(newOrder.total).isEqualTo(10.0)

        verify(priceService, times(1)).findPriceBy(recipe)
    }

    @Test
    fun `Happy pass - add a new item to the existing order`() {
        doReturn(10.0).`when`(priceService).findPriceBy(recipe)

        val newOrder = createOrder(recipe, 3)
        val item = newOrder.sellItems[0].item

        val order = createOrderService.addItemTo(item, newOrder, 2)

        assertThat(order.sellItems).size().isEqualTo(1)
        assertThat(order.sellItems).allMatch { it.item.recipe == recipe }
        assertThat(order.sellItems).allMatch { it.amount == 5 }
        assertThat(newOrder.total).isEqualTo(50.0)

        verify(priceService, times(2)).findPriceBy(recipe)
    }

    @Test
    fun `Happy pass - create a new order by passing a set of sellItems`() {
        doReturn(10.0).`when`(priceService).findPriceBy(recipe)
        val sellItems = mutableSetOf<SellItem>()
        (1..10).forEach {
            sellItems.add(SellItem(createRandomItemByRecipe(recipe),
                priceService.findPriceBy(recipe)!!,
                1
            ))}
        assertTrue(sellItems.size > 0)
        assertThat(sellItems.size).isEqualTo(10)
        assertTrue(sellItems.all { it.amount == 1} )
        assertTrue(sellItems.all { it.price == 10.0} )
        assertTrue(sellItems.all { it.item.recipe == recipe})

        verify(priceService, times(10)).findPriceBy(recipe)

    }

    @Test
    fun `Negative pass - adding negative amount`() {
        doReturn(10.0).`when`(priceService).findPriceBy(recipe)

        val newOrder = createOrder(recipe, 5)
        val item = newOrder.sellItems[0].item
        val order = createOrderService.addItemTo(item, newOrder, -7)
        assertFalse(order.sellItems[0].amount == -2)

        verify(priceService, times(2)).findPriceBy(recipe)
    }

    @Test
    fun `Happy pass - the item is deleted from the selliItems`() {
        doReturn(10.0).`when`(priceService).findPriceBy(recipe)
        val sellItems = mutableSetOf<SellItem>()
        (1..10).forEach {
            sellItems.add(SellItem(createRandomItemByRecipe(recipe),
                priceService.findPriceBy(recipe)!!,
                1
            ))}
        val order = createOrderFromSellItems(sellItems)

        createOrderService.delete(order, sellItems.first().item)
        assertEquals(90.0, order.total)
        assertEquals(9, order.sellItems.size)

        verify(priceService, times(11)).findPriceBy(recipe)

    }

    fun createOrderFromSellItems(sellItems: Set<SellItem>): Order {
        return createOrderService.createNewOrder(sellItems)
    }

    private fun createOrder(recipe: Recipe, amount: Int): Order {
        return createOrderService.createNewOrder(createRandomItemByRecipe(recipe), amount)
    }

    private fun createRandomItemByRecipe(recipe: Recipe): Recipy {
        return Recipy(
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