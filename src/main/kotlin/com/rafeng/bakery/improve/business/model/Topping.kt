package com.rafeng.bakery.improve.business.model

/**
 * This class describes a topping that can be created to be used in bakery's production.
 */
data class Topping(
    val name: String,
    val description: String,
    val type: ToppingType,
    val taste: Taste
)