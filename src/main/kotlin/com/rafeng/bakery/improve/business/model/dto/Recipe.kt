package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.model.entity.RecipeEntity

/**
 * This class describes the recipe of an item
 */
data class Recipe(
    val id: Long? = null,
    val name: String,
    val description: String,
    val expirationPeriod: Int,
    val cookingTime: Double
)

fun Recipe.toEntity() = RecipeEntity().apply {
    this@apply.id = this@toEntity.id
    this@apply.name = this@toEntity.name
    this@apply.description = this@toEntity.description
    this@apply.expirationPeriod = this@toEntity.expirationPeriod
    this@apply.cookingTime = this@toEntity.cookingTime
}
