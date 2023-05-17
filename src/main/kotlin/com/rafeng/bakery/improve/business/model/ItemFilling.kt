package com.rafeng.bakery.improve.business.model

/**
 * This class describes item's filling and its weight
 */
data class ItemFilling(
    val name: String,
    val weight: Double,
    val ratio: Float,
    val description: String,
    val filling: List<Filling>
)