package com.rafeng.bakery.improve.business.service.spring

import com.rafeng.bakery.improve.business.model.entity.EntityTransfer
import org.springframework.data.repository.CrudRepository

abstract class DefaultSpringService<E : EntityTransfer<D>, D>(
    protected open val defaultEntityRepository: CrudRepository<E, Long>,
    protected open val mapper: Mapper<E, D>
) {

    fun save(dto: D): D {
        return defaultEntityRepository.save(mapper.toEntity(dto)).let { it.toDto() }
    }

    fun get(): List<D> {
        return defaultEntityRepository.findAll().map { it.toDto() }
    }

    fun delete(id: Long): List<D> {
        defaultEntityRepository.deleteById(id)
        return defaultEntityRepository.findAll().map { it.toDto() }
    }
}

interface Mapper<E, D> {
    fun toDto(entity: E): D
    fun toEntity(dto: D): E
}