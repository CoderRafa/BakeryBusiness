package com.rafeng.bakery.improve.business.service.general

import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.MenuItem
import com.rafeng.bakery.improve.business.repository.impl.MenuRepository
import com.rafeng.bakery.improve.business.service.PriceService
import org.springframework.stereotype.Service

/**
 * This class can add an Item to a menu
 * This class can delete an Item from a menu
 * This class can get all the items in a menu
 */
@Service
class MenuServiceImpl(
    private val priceService: PriceService,
    private val menuRepository: MenuRepository = MenuRepository()
) : DefaultServiceImpl<Item, MenuRepository>(menuRepository) {
    /**
     * This function can get all the items and its price in a menu
     */
    fun getAllMenuItems(): List<MenuItem> {
        return menuRepository
            .getAll()
            .map {
                MenuItem(it, priceService.findPriceBy(it.recipe.id!!)!!)
            }
    }
}