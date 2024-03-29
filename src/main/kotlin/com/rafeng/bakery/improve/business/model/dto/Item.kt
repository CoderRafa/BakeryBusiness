package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.common.generateUniqueStringIdentifier
import com.rafeng.bakery.improve.business.model.Allergen
import com.rafeng.bakery.improve.business.model.ItemSize
import com.rafeng.bakery.improve.business.model.ItemSmell
import com.rafeng.bakery.improve.business.model.TasteType
import java.time.LocalDateTime

/**
 * This class describes an item that can be produced in the bakery
 */
data class Item(
    val id: String = generateUniqueStringIdentifier(),
    val name: String,
    val weight: Double,
    val size: ItemSize = ItemSize.SMALL,
    val smell: ItemSmell = ItemSmell.STRONG,
    val tasteType: TasteType = TasteType.SWEET,
//    val filling: List<ItemFilling> = listOf(
//        ItemFilling(
//            Filling(
//                "jam",
//                "nice jam",
//                FillingType.JAM,
//                TasteType.SWEET
//            ),
//            20.0
//        )
//    ),
//    val topping: List<ItemTopping> = listOf(
//        ItemTopping(
//            Topping(
//                "shaving",
//                "nice shaving",
//                ToppingType.SHAVING,
//                TasteType.SWEET
//                ),
//            20.0
//            )),
    val calories: Int,
    val allergens: List<Allergen> = listOf(Allergen.WALNUT),
    val isVegan: Boolean = false,
    var recipe: Recipe
) {
    var createDate: LocalDateTime = LocalDateTime.now()

    constructor(
        name: String,
        weight: Double,
        size: ItemSize,
        smell: ItemSmell,
        tasteType: TasteType,
//        filling: List<ItemFilling>,
//        topping: List<ItemTopping>,
        calories: Int,
        allergens: List<Allergen>,
        isVegan: Boolean,
        recipe: Recipe,
        createDate: LocalDateTime
    ) : this(
        generateUniqueStringIdentifier(),
        name,
        weight,
        size,
        smell,
        tasteType,
//        filling,
//        topping,
        calories,
        allergens,
        isVegan,
        recipe
    ) {
        this.createDate = createDate
    }
}