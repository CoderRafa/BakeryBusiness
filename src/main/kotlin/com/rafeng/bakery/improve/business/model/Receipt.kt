package com.rafeng.bakery.improve.business.model

import com.rafeng.bakery.improve.business.common.generateUniqueStringIdentifier
import com.rafeng.bakery.improve.business.model.dto.Order

data class Receipt(
    val id: String = generateUniqueStringIdentifier(),
    val order: Order,
    val client: Client,
    val path: String
)