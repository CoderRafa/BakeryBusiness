package com.rafeng.bakery.improve.business.model

import com.rafeng.bakery.improve.business.common.generateUniqueStringIdentifier

data class Client(
    val id: String = generateUniqueStringIdentifier(),
    val name: String,
    val lastname: String,
    val phoneNumber: String
)
