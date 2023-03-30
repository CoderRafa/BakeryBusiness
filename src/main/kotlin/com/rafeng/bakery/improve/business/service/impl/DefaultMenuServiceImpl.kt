package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.repository.MenuRepository
import com.rafeng.bakery.improve.business.model.dto.MenuItem
import com.rafeng.bakery.improve.business.service.MenuService
import com.rafeng.bakery.improve.business.service.PriceService

/**
 * This class can add an Item to a menu
 * This class can delete an Item from a menu
 * This class can get all the items in a menu
 */
class DefaultMenuServiceImpl(
    private val priceService: PriceService,
    private val menuRepository: MenuRepository = MenuRepository()
) : MenuService {
    /**
     * This function can add an Item to a menu
     */
    override fun addItem(item: Item): Boolean {
        return menuRepository.save(item)
    }

    /**
     * This function can delete an Item from a menu
     */
    override fun deleteItem(item: Item): Boolean {
        return menuRepository.delete(item)
    }

    /**
     * This function can get all the items and its price in a menu
     */
    override fun getAll(): List<MenuItem> {
        return menuRepository
            .getAll()
            .map {
                MenuItem(it, priceService.findPriceBy(it.recipe)!!)
            }
    }
}