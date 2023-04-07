package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.PriceService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PriceServiceImplTest {
    val priceService = PriceServiceImpl()
    var prices: MutableMap<Recipe, Double> = mutableMapOf()
    val recipe = Recipe(
        name = "bun",
        description = "Tasty bun",
        expirationPeriod = 2,
        cookingTime = 1.0,
    )


    @BeforeEach
    fun setUp() {
        val privateField = PriceServiceImpl::class.java.getDeclaredField("prices")
        privateField.isAccessible = true
        val prices = privateField.get()
        prices
    }

    @Test
    fun `Happy pass - the price is found`() {

        println(prices[recipe])
        assertEquals(20.0, priceService.findPriceBy(recipe))
        assertEquals(1, prices.size)
    }

    @Test
    fun addPriceFor() {
    }
}