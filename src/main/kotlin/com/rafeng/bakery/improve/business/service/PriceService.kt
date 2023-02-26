package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.Recipe

/**
 * This interface can assign a price to an item according to its recipe
 * This interface can get the price of an item according to its recipe
 */
interface PriceService {
    /**
     * This function returns the price of an item according to its recipe.
     */
    fun findPriceBy(recipe: Recipe): Double?
    /**
     * This function gives an opportunity to assign a price to an item according to its recipe.
     */
    fun addPriceFor(recipe: Recipe, price: Double)
}
