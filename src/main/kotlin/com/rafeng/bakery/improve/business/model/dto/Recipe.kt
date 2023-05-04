package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.common.generateUniqueStringIdentifier

/**
 * This class describes the recipe of an item
 */
data class Recipe(
    val id: String = generateUniqueStringIdentifier(),
    val name: String,
    val description: String,
    val expirationPeriod: Int,
    val cookingTime: Double
)
