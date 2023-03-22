package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Depot
import com.rafeng.bakery.improve.business.model.Recipe
import com.rafeng.bakery.improve.business.service.DepotService

class DepotServiceImpl(): DepotService {

    val depot = Depot(mutableMapOf<Recipe, Int>())
    override fun addItem(recipe: Recipe, amount: Int): Boolean {
        //return depot.items.put(recipe, amount)
    }

    override fun deleteItem(recipe: Recipe) {
        depot.items.remove(recipe)
    }

    override fun gelAll() {

    }

}