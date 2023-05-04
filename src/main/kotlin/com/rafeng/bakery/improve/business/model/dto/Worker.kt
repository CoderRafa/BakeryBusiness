package com.rafeng.bakery.improve.business.model.dto

import com.rafeng.bakery.improve.business.common.generateUniqueStringIdentifier

/**
 * This class describes a worker of the bakery
 */
data class Worker(
    val id: String = generateUniqueStringIdentifier(),
    var name: String,
    var lastname: String,
    val position: Position
)