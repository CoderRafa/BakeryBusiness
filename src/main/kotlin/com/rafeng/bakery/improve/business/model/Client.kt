package com.rafeng.bakery.improve.business.model

import com.rafeng.bakery.improve.business.common.generateUniqueStringIdentifier
import com.rafeng.bakery.improve.business.model.entity.ClientEntity

data class Client(
    val id: Long? = null,
    val name: String,
    val lastname: String,
    val phoneNumber: String
)

fun Client.toEntity() = ClientEntity().apply{
    this@apply.id = this@toEntity.id
    this@apply.name = this@toEntity.name
    this@apply.lastname = this@toEntity.lastname
    this@apply.phoneNumber = this@toEntity.phoneNumber
}