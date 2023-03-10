package com.rafeng.bakery.improve.business.model

import java.time.LocalDateTime

/**
 * This class describes an item that can be produced in the bakery
 */
data class Recipy(
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
    val recipe: Recipe
) {
    var createDate: LocalDateTime = LocalDateTime.now()

    constructor(
        name: String,
        weight: Double,
        size: ItemSize,
        smell: ItemSmell,
        taste: Taste,
        filling: List<ItemFilling>,
        topping: List<ItemTopping>,
        calories: Int,
        allergens: List<Allergen>,
        isVegan: Boolean,
        recipe: Recipe,
        createDate: LocalDateTime
    ) : this(
        name,
        weight,
        size,
        smell,
        taste,
        filling,
        topping,
        calories,
        allergens,
        isVegan,
        recipe
    ) {
        this.createDate = createDate
    }
}