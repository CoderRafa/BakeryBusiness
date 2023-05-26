package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.ItemToppingEntity
import org.springframework.data.repository.CrudRepository

interface ItemToppingEntityRepository: CrudRepository<ItemToppingEntity, Long> {
}