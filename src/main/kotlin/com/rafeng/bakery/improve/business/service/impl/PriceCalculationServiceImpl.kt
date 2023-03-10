package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Recipe
import com.rafeng.bakery.improve.business.model.Recipy
import com.rafeng.bakery.improve.business.service.CheckPriceService
import com.rafeng.bakery.improve.business.service.PriceCalculationService
import com.rafeng.bakery.improve.business.service.PriceService

class PriceCalculationServiceImpl(
    val priceService: PriceService,
    val checkPriceService: CheckPriceService
) : PriceCalculationService {
    override fun createPrice(price: Double, recipe: Recipe) {
        if (checkPriceService.checkPrice(price, recipe)) {
            priceService.addPriceFor(recipe, price)
        }
    }

    override fun fillDepoElement(item: Recipy, amount: Int) {
        TODO("Not yet implemented")
    }
}