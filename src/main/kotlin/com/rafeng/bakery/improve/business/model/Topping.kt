package com.rafeng.bakery.improve.business.model

data class Topping(
    val name: String,
    val description: String,
    val type: ToppingType,
    val taste: Taste
)