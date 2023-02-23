package com.rafengimprove.bakerybusiness.model

import java.time.LocalDate

open class Item(
    val name: String,
    val weight: Double,
    val size: ItemSize,
    val smell: ItemSmell,
    val taste: Taste,
    val filling: List<ItemFilling>,
    val topping: List<ItemTopping>,
    val calories: Int,
    val allergens: List<Allergen>,
    val isVegan: Boolean
)

 class BakedGoodItem(
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
     val recipe: Recipe
): Item(
     name,
     weight,
     size,
     smell,
     taste,
     filling,
     topping,
     calories,
     allergens,
     isVegan
)

class SellingItem(
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
    val expirationDate: LocalDate,
    var amount: Int,
    val price: Double
): Item(
    name,
    weight,
    size,
    smell,
    taste,
    filling,
    topping,
    calories,
    allergens,
    isVegan
) {
    override fun toString(): String {
        return """
                  name = $name, 
                  weight = $weight g, 
                  size = $size, 
                  smell = $smell, 
                  taste = $taste, 
                  filling = $filling, 
                  topping = $topping, 
                  calories = $calories, 
                  allergens = $allergens, 
                  isVegan = $isVegan, 
                  exp.date = $expirationDate, 
                  amount = $amount,
                  price = $price $
                """
    }
}

enum class Allergen {
    WALNUT, STRAWBERRY, MUSHROOM
}

data class Topping(
    val name: String,
    val description: String,
    val type: ToppingType,
    val taste: Taste
)

enum class ToppingType {
    CREAM, SHAVING, LIQUID
}

data class Filling(
    val name: String,
    val description: String,
    val type: FillingType,
    val taste: Taste
)

enum class Taste {
    SWEET, SPICY, SALTY, SOUR
}

enum class FillingType {
    JAM, LIQUID, SOLID
}

data class ItemFilling(
    val filling: Filling,
    val weight: Double
)

data class ItemTopping(
    val topping: Topping,
    val weight: Double
)

enum class ItemSmell {
    WEAK, MILD, STRONG,
}

enum class ItemSize {
    SMALL, MEDIUM, LARGE
}

data class Recipe(
    val name: String,
    val description: String
)
