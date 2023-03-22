package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.repository.DepotRepository
import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.repository.delete
import com.rafeng.bakery.improve.business.repository.save
import com.rafeng.bakery.improve.business.service.DepotService

class DepotServiceImpl(): DepotService {

    private val depotRepository = DepotRepository()
    override fun addItem(recipe: Recipe, amount: Int): Boolean {
        return depotRepository.save(recipe, amount)
    }

    override fun deleteItem(recipe: Recipe): Boolean {
        return depotRepository.delete(recipe)
    }

    override fun gelAll(): Map<Recipe, Int> {
        return depotRepository.items
    }

}