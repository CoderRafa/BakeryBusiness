package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.PriceService

/**
 * This service can assign a price to a certain item.
 * This service can get the price of an item according to its recipe
 */

class PriceServiceImpl : PriceService {
    private val prices: MutableMap<Recipe, Double> = mutableMapOf()
    /**
     * This function returns the price of an item according to its recipe.
     */
    override fun findPriceBy(recipe: Recipe): Double? = prices[recipe]
    /**
     * This function gives an opportunity to assign a price to an item according to its recipe.
     */
    override fun addPriceFor(recipe: Recipe, price: Double) {
        prices[recipe] = price
    }
}