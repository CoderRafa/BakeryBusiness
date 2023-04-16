package com.rafeng.bakery.improve.business.model

import com.rafeng.bakery.improve.business.model.dto.Order
import java.io.File

data class Receipt(
    val order: Order,
    val client: Client,
    val path: String
)