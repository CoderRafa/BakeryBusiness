package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.Recipe
import com.rafeng.bakery.improve.business.model.Recipy

/**
* This interface creates a price for an item according to its recipe
 */
interface PriceCalculationService {
    fun createPrice(price: Double, recipe: Recipe)
    fun fillDepoElement(item: Recipy, amount: Int)
}