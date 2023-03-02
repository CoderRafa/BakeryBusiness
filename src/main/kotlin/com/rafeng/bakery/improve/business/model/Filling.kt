package com.rafeng.bakery.improve.business.model

/**
 * This class describes a filling that can be created to be used in bakery's production.
 */
data class Filling(
    val name: String,
    val description: String,
    val type: FillingType,
    val taste: Taste
)