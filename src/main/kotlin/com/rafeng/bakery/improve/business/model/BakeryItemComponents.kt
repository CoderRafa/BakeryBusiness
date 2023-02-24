package com.rafeng.bakery.improve.business.model


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
    val description: String,
    val expirationPeriod: Int,
    val cookingTime: Double
)
