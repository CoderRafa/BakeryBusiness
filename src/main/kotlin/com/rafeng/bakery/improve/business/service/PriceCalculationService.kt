package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.Item
import com.rafeng.bakery.improve.business.model.Recipe

/**
* This interface creates a price for an item according to its recipe
 */
interface PriceCalculationService {
    fun createPrice(price: Double, item: Item): Double?
}