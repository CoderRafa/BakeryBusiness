package com.old

import com.rafeng.bakery.improve.business.service.CheckPriceService
import com.rafeng.bakery.improve.business.service.PriceCalculationService
import com.rafeng.bakery.improve.business.service.PriceService
import com.rafeng.bakery.improve.business.service.general.CheckPositivePriceAndNonEmptyRecipeDescriptionServiceImpl
import com.rafeng.bakery.improve.business.service.general.PriceCalculationServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PriceCalculationServiceImplTest {

    @Mock
    private lateinit var priceService: PriceService

    private lateinit var checkPriceService: CheckPriceService

    private lateinit var priceCalculationService: PriceCalculationService

    @BeforeEach
    fun setUp() {
        checkPriceService = CheckPositivePriceAndNonEmptyRecipeDescriptionServiceImpl()
        priceCalculationService = PriceCalculationServiceImpl(priceService, checkPriceService)
    }

    @Test
    fun createPrice() {
    }
}