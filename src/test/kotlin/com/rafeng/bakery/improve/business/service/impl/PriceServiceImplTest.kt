package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.service.PriceService
import com.rafeng.bakery.improve.business.util.createRecipe
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PriceServiceImplTest {
    private lateinit var priceService: PriceService
    private val recipe = createRecipe()

    @BeforeEach
    fun setUp() {
        priceService = PriceServiceImpl()
    }

    @Test
    fun `Happy pass - the price is found`() {
        priceService.addPriceFor(recipe.id!!, 10.0)
        assertEquals(10.0, priceService.findPriceBy(recipe.id!!))
    }
}