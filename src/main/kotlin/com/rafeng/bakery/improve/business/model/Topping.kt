package com.rafeng.bakery.improve.business.model

/**
 * This class describes a topping that can be created to be used in bakery's production.
 */
data class Topping(
    val id: Long? = null,
    val name: String,
    val description: String,
    val type: ToppingType,
    val tasteType: TasteType
)