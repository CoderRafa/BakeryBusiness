package com.rafeng.bakery.improve.business.repository

/**
 * This interface allows to use any type instead of T
 */
interface DefaultRepository<T> {

    /**
     * This function can save an item of type T
     */
    fun save(item: T): Boolean

    /**
     * This function can delete an item of type T
     */
    fun delete(item: T): Boolean

    /**
     * This function can get all the items of type T
     */
    fun getAll(): Iterable<T>
}