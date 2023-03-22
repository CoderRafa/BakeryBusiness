package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.Recipe

interface DepotService {
    fun addItem(recipe: Recipe, amount: Int): Boolean
    fun deleteItem(recipe: Recipe): Boolean
    fun gelAll(): Map<Recipe, Int>
}