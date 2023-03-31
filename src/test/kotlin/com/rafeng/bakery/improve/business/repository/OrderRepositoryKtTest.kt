package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.*
import com.rafeng.bakery.improve.business.model.dto.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDateTime
import kotlin.random.Random
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextInt

class OrderRepositoryKtTest {

    private lateinit var orderRepo: OrderRepository
    private val recipe = Recipe("test", "super test", 2, 2.15)
    @BeforeEach
    fun setUp() {
        orderRepo = OrderRepository()
        orderRepo.save(createRandomOrder(recipe))
        orderRepo.save(createRandomOrder(recipe))
    }

    @Test
    fun `Happy pass - an order was added to the list of orders`() {
        val order = createRandomOrder(recipe)
        assertEquals(2,  orderRepo.getAll().size)
        orderRepo.save(order)
        assertEquals(3,  orderRepo.getAll().size)
    }

    @Test
    fun `Happy pass - an order was successfully deleted`() {
        val order = createRandomOrder(recipe)
        assertEquals(2,  orderRepo.getAll().size)
        orderRepo.save(order)
        assertEquals(3,  orderRepo.getAll().size)
        orderRepo.delete(order)
        assertEquals(2,  orderRepo.getAll().size)
    }

    @Test
    fun `Happy pass - get all the orders from the mutable list`() {
        val order = createRandomOrder(recipe)
        assertEquals(2, orderRepo.getAll().size)
        orderRepo.save(order)
        orderRepo.save(order)
        assertEquals(4, orderRepo.getAll().size)
    }
}

fun createRandomOrder(recipe: Recipe): Order {
    return Order(
        mutableListOf(
            createRandomSellItem(recipe),
            createRandomSellItem(recipe),
            createRandomSellItem(recipe)
            ),
        Random.nextDouble(2.0,7.0),
        LocalDateTime.now(),
        Random.nextDouble(2.0,5.0),
        Worker("Lena", "Trofimova", Position.SALESPERSON),
        PaymentType.values()[nextInt(0, ItemSize.values().size - 1)]
    )
}

fun createRandomSellItem(recipe: Recipe): SellItem {
    return SellItem(
        createRandomItemByRecipe(recipe),
        nextDouble(2.0, 10.0),
        nextInt(3, 20)
    )
}

fun createRandomItemByRecipe(recipe: Recipe): Item {
    return Item(
        ('a'..'z').take(Random.nextInt(1, 27)).joinToString(""),
        Random.nextDouble(),
        ItemSize.values()[Random.nextInt(0, ItemSize.values().size - 1)],
        ItemSmell.STRONG,
        Taste.SWEET,
        listOf(ItemFilling(Filling("test", "super test", FillingType.JAM, Taste.SWEET), 10.0)),
        listOf(ItemTopping(Topping("test", "super test", ToppingType.CREAM, Taste.SWEET), 10.0)),
        300,
        listOf(),
        false,
        recipe,
        LocalDateTime.now()

    )
}