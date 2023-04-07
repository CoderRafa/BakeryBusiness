package com.rafeng.bakery.improve.business.service

/**
 * The interface can add a new item to a menu.
 * The interface can delete an item from a menu.
 * The interface can get all the items from a menu.
 */
interface DefaultService<T> {
    /**
     * This function can add a new item to a menu.
     */
    fun addItem(item: T): Boolean

    /**
     * This function can delete an item from a menu.
     */
    fun deleteItem(item: T): Boolean

    /**
     * This function can get all the items from a menu.
     */
    fun getAll(): List<T>
}