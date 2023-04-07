package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.repository.DefaultRepository
import com.rafeng.bakery.improve.business.service.DefaultService

abstract class DefaultServiceImpl<T, R : DefaultRepository<T>>(open val repository: R) : DefaultService<T> {
    override fun addItem(item: T): Boolean = repository.save(item)
    override fun deleteItem(item: T): Boolean = repository.delete(item)
    override fun getAll(): List<T> = repository.getAll().toList()
}