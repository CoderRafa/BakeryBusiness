package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.dto.Recipe

/**
 * The interface can add a new item to a depot.
 * The interface can delete an item from a depot.
 * The interface can get all the items from a depot.
 */
interface DepotService {
    /**
     * This function can add a new item to a depot.
     */
    fun addItem(recipe: Recipe, amount: Int): Boolean
    /**
     * This function can delete an item from a depot.
     */
    fun deleteItem(recipe: Recipe): Boolean
    /**
     * This function can get all the items from a depot.
     */
    fun gelAll(): Map<Recipe, Int>
}