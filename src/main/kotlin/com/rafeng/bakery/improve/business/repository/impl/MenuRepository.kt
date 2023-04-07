package com.rafeng.bakery.improve.business.repository.impl

import com.rafeng.bakery.improve.business.model.dto.Item

/**
 * This class describes menu items in the menu
 */
data class MenuRepository(
    private val menuItems: MutableSet<Item> = mutableSetOf()
) : DefaultRepositoryImpl<Item>(menuItems)