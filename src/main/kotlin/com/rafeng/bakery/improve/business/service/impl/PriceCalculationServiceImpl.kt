package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.CheckPriceService
import com.rafeng.bakery.improve.business.service.PriceCalculationService
import com.rafeng.bakery.improve.business.service.PriceService

/**
 * This service can assign a price to a recipe if that price and recipe meet the condition
 */
class PriceCalculationServiceImpl(
    val priceService: PriceService,
    val checkPriceService: CheckPriceService
) : PriceCalculationService {
    /**
     * This function assigns a price to a recipe if that price and recipe meet the condition
     */
    override fun createPrice(price: Double, recipe: Recipe) {
        if (checkPriceService.checkPrice(price, recipe)) {
            priceService.addPriceFor(recipe, price)
        }
    }
}