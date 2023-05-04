package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.PriceService

class HashMapPriceServiceImpl(private val accumulator: MutableMap<String, Double> = mutableMapOf()
) : PriceService, MutableMap<String, Double> by accumulator {
    override fun findPriceBy(id: String): Double? = this[id]


    override fun addPriceFor(id: String, price: Double) {
        this[id] = price
    }
}
