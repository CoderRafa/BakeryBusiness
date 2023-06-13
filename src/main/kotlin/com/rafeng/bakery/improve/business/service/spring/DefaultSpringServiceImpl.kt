package com.rafeng.bakery.improve.business.service.spring

import com.rafeng.bakery.improve.business.service.DefaultEntityRepository
import org.springframework.stereotype.Service

abstract class DefaultSpringServiceImpl<T,R>(
        private val defaultEntityRepository: DefaultEntityRepository<T>
) {

    fun save(dto: R): R {
        return defaultEntityRepository.save(dto.toEntity()).toDto()
    }

    fun get(): List<R> {
        return defaultEntityRepository.findAll().map {it.toDto()}
    }

    fun delete(id: Long): List<R> {
        defaultEntityRepository.deleteById(id)
        return defaultEntityRepository.findAll().map { it.toDto() }
    }
}