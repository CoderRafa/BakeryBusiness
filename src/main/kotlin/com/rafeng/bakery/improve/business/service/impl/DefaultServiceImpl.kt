package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.repository.DefaultRepository
import com.rafeng.bakery.improve.business.service.DefaultService

/**
 * This abstract class can add, delete and get items of a type that we set to and from a repository of a type that we have set
 */

abstract class DefaultServiceImpl<T, R : DefaultRepository<T>>(open val repository: R) : DefaultService<T> {
    /**
     * This function can add an item of a type that we have set to a repository of the same type
     */
    override fun addItem(item: T): Boolean = repository.save(item)
    /**
     * This function can delete an item of a type that we have set to a repository of the same type
     */
    override fun deleteItem(item: T): Boolean = repository.delete(item)
    /**
     * This function can get all the items of a type that we have set to a repository of the same type
     */
    override fun getAll(): List<T> = repository.getAll().toList()
}