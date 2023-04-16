package com.rafeng.bakery.improve.business.model.dto

/**
 * This class describes a worker of the bakery
 */
data class Worker(
    val name: String,
    val lastname: String,
    val position: Position
)