package com.rafeng.bakery.improve.business.repository.impl

import com.rafeng.bakery.improve.business.model.dto.Item
import org.springframework.stereotype.Component

/**
 * This class describes menu items in the menu
 */
@Component
data class MenuRepository(
    private val menuItems: MutableSet<Item> = mutableSetOf()
) : DefaultRepositoryImpl<Item>(menuItems)