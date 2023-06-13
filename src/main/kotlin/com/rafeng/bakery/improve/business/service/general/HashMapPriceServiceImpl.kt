package com.rafeng.bakery.improve.business.service.general

import com.rafeng.bakery.improve.business.service.PriceService
import org.springframework.context.annotation.Profile

@Profile("HashMapProfile")
class HashMapPriceServiceImpl(
    private val accumulator: MutableMap<Long, Double> = mutableMapOf()
) : PriceService, MutableMap<Long, Double> by accumulator {
    override fun findPriceBy(id: Long): Double? = this[id]


    override fun addPriceFor(id: Long, price: Double) {
        this[id] = price
    }
}
