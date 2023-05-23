package com.rafeng.bakery.improve.business.model

import com.rafeng.bakery.improve.business.model.entity.FillingEntity

/**
 * This class describes a filling that can be created to be used in bakery's production.
 */
data class Filling(
    var id: Long? = null,
    val name: String,
    val description: String,
    val fillingType: FillingType,
    val tasteType: TasteType
)

fun Filling.toEntity() = FillingEntity().apply {
    this@apply.id = this@toEntity.id
    this@apply.name = this@toEntity.name
    this@apply.description = this@toEntity.description
    this@apply.fillingType = this@toEntity.fillingType
    this@apply.tasteType = this@toEntity.tasteType
}