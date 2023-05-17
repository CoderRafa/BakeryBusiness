package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.common.generateUniqueStringIdentifier
import com.rafeng.bakery.improve.business.model.entity.WorkerEntity

/**
 * This class describes a worker of the bakery
 */
data class Worker(
    val id: Long? = null,
    var name: String,
    var lastname: String,
    val position: Position
)

fun Worker.toEntity() = WorkerEntity().apply{
    this@apply.id = this@toEntity.id
    this@apply.name = this@toEntity.name
    this@apply.lastname = this@toEntity.lastname
    this@apply.position = this@toEntity.position
}