package com.rafeng.bakery.improve.business.model

/**
 * This class describes the item that are in stock and their amount.
 */
data class Depot(
    val items: Map<Item, Int>
)