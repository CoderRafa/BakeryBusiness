package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.dto.Item

/**
 * This class describes menu items in the menu
 */
data class MenuRepository(
    private val menuItems: MutableSet<Item> = mutableSetOf()
) {

    /**
     * This function adds an item to the menu
     */
    fun save(item: Item): Boolean {
        return this.menuItems.add(item)
    }

    /**
     * This function deletes an item from the menu
     */
    fun delete(item: Item): Boolean {
        return this.menuItems.remove(item)
    }

    /**
     * This function gets all the items in the menu
     */
    fun getAll(): MutableSet<Item> {
        return this.menuItems
    }
}