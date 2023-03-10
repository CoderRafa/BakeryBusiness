package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.Recipe

interface CheckPriceService {
    fun checkPrice(price: Double, recipe: Recipe): Boolean
}
