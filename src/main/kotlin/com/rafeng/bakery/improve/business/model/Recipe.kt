package com.rafeng.bakery.improve.business.model

/**
 * This class describes the recipe of an item
 */
data class Recipe(
    val name: String,
    val description: String,
    val expirationPeriod: Int,
    val cookingTime: Double
)
