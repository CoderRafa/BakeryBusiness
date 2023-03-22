package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.dto.Recipe

/**
 * This class describes the item that are in stock and their amount.
 */
data class DepotRepository(
    val items: MutableMap<Recipe, Int> = mutableMapOf()
)

fun DepotRepository.save(recipe: Recipe, amount: Int): Boolean {
    this.items[recipe] = amount
    return this.items.containsKey(recipe)
}

fun DepotRepository.delete(recipe: Recipe): Boolean {
    this.items.remove(recipe)
    return this.items.notContains(recipe)
}

private fun <K, V> MutableMap<K, V>.notContains(key: K) = !this.contains(key)