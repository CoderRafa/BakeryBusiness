package com.rafeng.bakery.improve.business.model.dto

/**
 * This class describes a worker of the bakery
 */
data class Worker(
    var name: String,
    var lastname: String,
    val position: Position
)