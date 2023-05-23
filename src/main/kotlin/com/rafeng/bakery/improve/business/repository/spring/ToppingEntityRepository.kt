package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.ToppingEntity
import org.springframework.data.repository.CrudRepository

interface ToppingEntityRepository: CrudRepository<ToppingEntity, Long> {
}