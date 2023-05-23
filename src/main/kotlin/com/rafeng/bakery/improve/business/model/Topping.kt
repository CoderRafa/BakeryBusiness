package com.rafeng.bakery.improve.business.model

import com.rafeng.bakery.improve.business.model.entity.ToppingEntity

/**
 * This class describes a topping that can be created to be used in bakery's production.
 */
data class Topping(
    val id: Long? = null,
    val name: String,
    val description: String,
    val toppingType: ToppingType,
    val tasteType: TasteType
)

fun Topping.toEntity() = ToppingEntity().apply {
    this@apply.id = this@toEntity.id
    this@apply.name = this@toEntity.name
    this@apply.description = this@toEntity.description
    this@apply.toppingType = this@toEntity.toppingType
    this@apply.tasteType = this@toEntity.tasteType
}