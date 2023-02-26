package com.rafeng.bakery.improve.business.model

data class Filling(
    val name: String,
    val description: String,
    val type: FillingType,
    val taste: Taste
)