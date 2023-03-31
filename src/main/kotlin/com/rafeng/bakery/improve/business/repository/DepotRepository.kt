package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.Recipe

/**
 * This class describes the items that are in stock and their amount.
 */
data class DepotRepository(
    private val items: MutableMap<Recipe, Int> = mutableMapOf()
) {

    /**
     * This function adds an item to Depot
     */
    fun save(recipe: Recipe, amount: Int): Boolean {
        this.items[recipe] = amount
        return this.items.containsKey(recipe)
    }

    /**
     * This function deletes an item from Depot
     */
    fun delete(recipe: Recipe): Boolean {
        this.items.remove(recipe)
        return this.items.notContains(recipe)
    }

    /**
     * This function gets all
     */
    fun getAll(): MutableMap<Recipe, Int> {
        return this.items
    }

    private fun <K, V> MutableMap<K, V>.notContains(key: K) = !this.contains(key)
}