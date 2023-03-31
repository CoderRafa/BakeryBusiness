package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.PriceService

class HashMapPriceServiceImpl(private val accumulator: MutableMap<Recipe, Double> = mutableMapOf()
) : PriceService, MutableMap<Recipe, Double> by accumulator {
    override fun findPriceBy(recipe: Recipe): Double? = this[recipe]


    override fun addPriceFor(recipe: Recipe, price: Double) {
        this[recipe] = price
    }
}
