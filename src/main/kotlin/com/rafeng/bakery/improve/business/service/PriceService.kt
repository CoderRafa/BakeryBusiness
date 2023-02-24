package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.Recipe

interface PriceService {
    fun findPriceBy(recipe: Recipe): Double?
    fun addPriceFor(recipe: Recipe, price: Double)
}
