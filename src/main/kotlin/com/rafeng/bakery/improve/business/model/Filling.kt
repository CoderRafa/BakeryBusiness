package com.rafeng.bakery.improve.business.model

/**
 * This class describes a filling that can be created to be used in bakery's production.
 */
data class Filling(
    val id: Long? = null,
    val name: String,
    val description: String,
    val fillingType: FillingType,
    val tasteType: TasteType
)