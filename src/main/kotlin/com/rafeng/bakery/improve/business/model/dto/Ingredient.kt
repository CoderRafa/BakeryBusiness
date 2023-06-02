package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.model.entity.IngredientEntity

data class Ingredient(
    val id: Long? = null,
    val name: String,
    val description: String,
    val productionDate: String,
    val expirationDate: String
) {
    init {
        assert(description.isNotEmpty() && description.length > 10) { "Some problems with the description!" }
    }
}

fun Ingredient.toEntity() = IngredientEntity().apply {
    this@apply.id = this@toEntity.id
    this@apply.name = this@toEntity.name
    this@apply.description = this@toEntity.description
    this@apply.productionDate = this@toEntity.productionDate
    this@apply.expirationDate = this@toEntity.expirationDate
}