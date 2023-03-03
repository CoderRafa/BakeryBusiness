package com.rafeng.bakery.improve.business.model

import java.time.LocalDateTime

/**
 * This class describes an item that can be produced in the bakery
 */
data class Item(
    val name: String,
    val weight: Double,
    val size: ItemSize,
    val smell: ItemSmell,
    val taste: Taste,
    val filling: List<ItemFilling>,
    val topping: List<ItemTopping>,
    val calories: Int,
    val allergens: List<Allergen>,
    val isVegan: Boolean,
    val recipe: Recipe,
    val createDate: LocalDateTime,
)