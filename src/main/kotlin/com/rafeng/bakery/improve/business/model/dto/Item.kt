package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.model.*
import java.time.LocalDateTime

/**
 * This class describes an item that can be produced in the bakery
 */
data class Item(
    val name: String,
    val weight: Double,
    val size: ItemSize = ItemSize.SMALL,
    val smell: ItemSmell = ItemSmell.STRONG,
    val taste: Taste = Taste.SWEET,
    val filling: List<ItemFilling> = listOf(
        ItemFilling(
            Filling(
                "jam",
                "nice jam",
                FillingType.JAM,
                Taste.SWEET
            ),
            20.0
        )
    ),
    val topping: List<ItemTopping> = listOf(
        ItemTopping(
            Topping(
                "shaving",
                "nice shaving",
                ToppingType.SHAVING,
                Taste.SWEET
                ),
            20.0
            )),
    val calories: Int,
    val allergens: List<Allergen> = listOf(Allergen.WALNUT),
    val isVegan: Boolean = false,
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