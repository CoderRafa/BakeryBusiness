package com.rafeng.bakery.improve.business.model

/**
 * This class describes item's topping and its weight
 */
data class ItemTopping(
    val name: String,
    val weight: Double,
    val ratio: Float,
    val description: String,
    val topping: List<Topping>
)