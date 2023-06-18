package com.rafeng.bakery.improve.business.model

import com.rafeng.bakery.improve.business.generic.DtoTransformer
import com.rafeng.bakery.improve.business.model.entity.ClientEntity

data class Client(
    val id: Long? = null,
    val name: String,
    val lastname: String,
    val phoneNumber: String
) : DtoTransformer<ClientEntity> {
    override fun toEntity(): ClientEntity {
        TODO("Not yet implemented")
    }
}