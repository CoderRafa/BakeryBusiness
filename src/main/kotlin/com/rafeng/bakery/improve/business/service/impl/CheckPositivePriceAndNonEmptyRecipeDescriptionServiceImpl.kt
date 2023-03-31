package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.CheckPriceService

/**
 * This service checks that the price is positive and the recipe description is not empty
 */

class CheckPositivePriceAndNonEmptyRecipeDescriptionServiceImpl: CheckPriceService {
    /**
     * This function checks that the price is positive and the recipe description is not empty
     */
    override fun checkPrice(price: Double, recipe: Recipe): Boolean {
       return price > 0 && recipe.description.isNotEmpty()
    }

}