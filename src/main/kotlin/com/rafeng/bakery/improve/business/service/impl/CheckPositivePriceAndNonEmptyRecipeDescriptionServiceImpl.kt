package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.CheckPriceService

/**
 * This service checks that the price is positive and the recipe description is not empty
 */

class CheckPositivePriceAndNonEmptyRecipeDescriptionServiceImpl: CheckPriceService {
    /**
    Determines whether a given price is valid and whether the provided recipe has a non-empty description.
    @param price The price to check. Must be a positive double value.
    @param recipe The recipe to check. Must not be null.
    @return True if the price is valid and the recipe has a non-empty description, false otherwise.
     */

    override fun checkPrice(price: Double, recipe: Recipe): Boolean {
       return price > 0 && (recipe).description.isNotEmpty()
    }

}