package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.MenuItem

/**
 * The interface can add a new item to a menu.
 * The interface can delete an item from a menu.
 * The interface can get all the items from a menu.
 */
interface MenuService {
    /**
     * This function can add a new item to a menu.
     */
    fun addItem(item: Item): Boolean
    /**
     * This function can delete an item from a menu.
     */
    fun deleteItem(item: Item): Boolean
    /**
     * This function can get all the items from a menu.
     */
    fun getAll(): List<MenuItem>
}