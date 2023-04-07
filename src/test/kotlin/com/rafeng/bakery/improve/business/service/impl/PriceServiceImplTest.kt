package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.PriceService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PriceServiceImplTest {
    private lateinit var priceService: PriceService
    private val recipe = Recipe(
        name = "bun",
        description = "Tasty bun",
        expirationPeriod = 2,
        cookingTime = 1.0,
    )

    @BeforeEach
    fun setUp() {
        priceService = PriceServiceImpl()
    }

    @Test
    fun `Happy pass - the price is found`() {
        priceService.addPriceFor(recipe, 10.0)
        assertEquals(10.0, priceService.findPriceBy(recipe))
    }
}