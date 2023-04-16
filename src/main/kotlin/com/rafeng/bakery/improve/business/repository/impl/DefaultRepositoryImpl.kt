package com.rafeng.bakery.improve.business.repository.impl

import com.rafeng.bakery.improve.business.repository.DefaultRepository

/**
 * This abstract class can save, delete and get items from and to a MutableCollection of a type that we can set
 */
abstract class DefaultRepositoryImpl<T>(open val accumulator: MutableCollection<T>): DefaultRepository<T> {
    /**
     * This function can save an item to a MutableCollection of a type that we have set
     */
    override fun save(item: T): Boolean = accumulator.add(item)
    /**
     * This function can delete an item from a MutableCollection of a type that we have set
     */
    override fun delete(item: T): Boolean = accumulator.remove(item)
    /**
     * This function can get all the items from a MutableCollection of a type that we have set
     */
    override fun getAll(): Collection<T> = accumulator
}