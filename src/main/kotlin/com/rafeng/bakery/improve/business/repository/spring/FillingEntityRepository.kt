package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.Filling
import com.rafeng.bakery.improve.business.model.entity.FillingEntity
import org.springframework.data.repository.CrudRepository

interface FillingEntityRepository: CrudRepository<FillingEntity, Long> {
}