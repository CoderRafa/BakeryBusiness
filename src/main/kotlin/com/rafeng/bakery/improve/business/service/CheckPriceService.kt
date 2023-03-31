package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.dto.Recipe

/**
 * This interface can check if the price and recipe meet the requirements
 */
interface CheckPriceService {
    /**
     * This function checks if the price and recipe meet the requirements
     */
    fun checkPrice(price: Double, recipe: Recipe): Boolean
}
