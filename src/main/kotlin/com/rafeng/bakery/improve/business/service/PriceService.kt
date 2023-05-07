package com.rafeng.bakery.improve.business.service

/**
 * This interface can assign a price to an item according to its recipe
 * This interface can get the price of an item according to its recipe
 */
interface PriceService {
    /**
     * This function returns the price of an item according to its recipe.
     */
    fun findPriceBy(recipeId: Long): Double?

    /**
     * This function gives an opportunity to assign a price to an item according to its recipe.
     */
    fun addPriceFor(recipeId: Long, price: Double)
}
