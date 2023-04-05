package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.repository.DepotRepository
import com.rafeng.bakery.improve.business.service.DepotService
import org.springframework.stereotype.Service

/**
 * This class can add an item and its amount to a depot
 * This class can delete an item from a depot
 * This class can get all the items in a depot
 */
@Service
class DepotServiceImpl(): DepotService {

    private val depotRepository = DepotRepository()
    /**
     * This function can add an item and its amount to a depot
     */
    override fun addItem(recipe: Recipe, amount: Int): Boolean {
        return depotRepository.save(recipe, amount)
    }

    /**
     * This function can delete an item from a depot
     */
    override fun deleteItem(recipe: Recipe): Boolean {
        return depotRepository.delete(recipe)
    }

    /**
     * This function can get all the items in a depot
     */
    override fun gelAll(): Map<Recipe, Int> {
        return depotRepository.getAll()
    }

}