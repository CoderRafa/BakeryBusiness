package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.WorkerEntity
import org.springframework.data.repository.CrudRepository

interface WorkerEntityRepository: CrudRepository<WorkerEntity, Long> {
}