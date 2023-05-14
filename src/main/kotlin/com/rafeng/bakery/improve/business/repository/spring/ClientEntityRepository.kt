package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.ClientEntity
import org.springframework.data.repository.CrudRepository

interface ClientEntityRepository: CrudRepository<ClientEntity, Long> {
}