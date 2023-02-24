package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Recipe
import com.rafeng.bakery.improve.business.service.PriceService

class PriceServiceImpl : PriceService {
    private val prices: MutableMap<Recipe, Double> = mutableMapOf()
    override fun findPriceBy(recipe: Recipe): Double? = prices[recipe]
    override fun addPriceFor(recipe: Recipe, price: Double) {
        prices[recipe] = price
    }
}