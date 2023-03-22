package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.repository.MenuRepository
import com.rafeng.bakery.improve.business.model.dto.MenuItem
import com.rafeng.bakery.improve.business.service.MenuService
import com.rafeng.bakery.improve.business.service.PriceService

class DefaultMenuServiceImpl(
    private val priceService: PriceService,
    private val menuRepository: MenuRepository = MenuRepository()
) : MenuService {
    override fun addItem(item: Item): Boolean {
        return menuRepository.menuItems.add(item)
    }

    override fun deleteItem(item: Item): Boolean {
        return menuRepository.menuItems.remove(item)
    }

    override fun getAll(): List<MenuItem> {
        return menuRepository
            .menuItems
            .map {
                MenuItem(it, priceService.findPriceBy(it.recipe)!!)
            }
    }
}