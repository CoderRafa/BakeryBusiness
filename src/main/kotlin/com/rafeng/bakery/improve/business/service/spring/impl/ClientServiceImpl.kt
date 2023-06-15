package com.rafeng.bakery.improve.business.service.spring.impl

import com.rafeng.bakery.improve.business.model.Client
import com.rafeng.bakery.improve.business.model.entity.ClientEntity
import com.rafeng.bakery.improve.business.repository.spring.ClientEntityRepository
import com.rafeng.bakery.improve.business.service.spring.DefaultSpringService
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl(override val defaultEntityRepository: ClientEntityRepository) :
    DefaultSpringService<ClientEntity, Client>(defaultEntityRepository) {
    override fun ClientEntity.toDto() = Client(id, name, lastname, phoneNumber)

    override fun Client.toEntity() = ClientEntity().apply {
        this@apply.id = this@toEntity.id
        this@apply.name = this@toEntity.name
        this@apply.lastname = this@toEntity.lastname
        this@apply.phoneNumber = this@toEntity.phoneNumber
    }
}