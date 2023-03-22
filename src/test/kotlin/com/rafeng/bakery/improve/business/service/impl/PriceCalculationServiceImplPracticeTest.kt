package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.CheckPriceService
import com.rafeng.bakery.improve.business.service.PriceCalculationService
import com.rafeng.bakery.improve.business.service.PriceService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PriceCalculationServiceImplPracticeTest {

    private lateinit var priceService: PriceService
    private lateinit var checkPriceService: CheckPriceService
    private lateinit var priceCalculationService: PriceCalculationService

    private val recipe = Recipe("name", "description", 2, 2.0)
    private val recipeWithNoDescription = Recipe("name", "", 2, 2.0)

    @BeforeEach
    fun setUp() {
        priceService = PriceServiceImpl()
        checkPriceService = CheckPositivePriceAndNonEmptyRecipeDescriptionServiceImpl()
        priceCalculationService = PriceCalculationServiceImpl(priceService, checkPriceService)
    }

    @Test
    fun `Happy pass - PriceCalculationService creates price`() {

        priceCalculationService.createPrice(10.0, recipe)
        assertEquals(10.0, priceService.findPriceBy(recipe) )
    }

    @Test
    fun `Negative pass - price doesn't meet the requirements`() {

        priceCalculationService.createPrice(0.0, recipe)
        assertNull(priceService.findPriceBy(recipe))
    }

    @Test
    fun `Negative pass - empty description`() {

        priceCalculationService.createPrice(15.0, recipeWithNoDescription)
        assertNull(priceService.findPriceBy(recipe))
    }
}