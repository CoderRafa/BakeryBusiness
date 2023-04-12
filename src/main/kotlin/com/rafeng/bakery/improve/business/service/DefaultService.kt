package com.rafeng.bakery.improve.business.service

/**
 * The interface can add a new item of a type that we set.
 * The interface can delete an item of a type that we set.
 * The interface can get all the items of a type that we set.
 */
interface DefaultService<T> {
    /**
     * This function can add a new item of a type that we have set.
     */
    fun addItem(item: T): Boolean

    /**
     * This function can delete an item of a type that we have set.
     */
    fun deleteItem(item: T): Boolean

    /**
     * This function can get all the items of a type that we have set.
     */
    fun getAll(): List<T>
}