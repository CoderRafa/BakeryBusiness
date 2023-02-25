package com.rafeng.bakery.improve.business.model


data class Recipe(
    val name: String,
    val description: String,
    val expirationPeriod: Int,
    val cookingTime: Double
)
