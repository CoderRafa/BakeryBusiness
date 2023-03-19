package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Item
import com.rafeng.bakery.improve.business.model.Menu
import com.rafeng.bakery.improve.business.model.MenuItem
import com.rafeng.bakery.improve.business.service.MenuService
import com.rafeng.bakery.improve.business.service.PriceService

class DefaultMenuServiceImpl(
    private val priceService: PriceService,
    private val menu: Menu = Menu(mutableSetOf())
) : MenuService {
    override fun addItem(item: Item): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteItem(item: Item): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<MenuItem> {
        return menu
            .menuItems
            .map {
                MenuItem(it, priceService.findPriceBy(it.recipe)!!)
            }
    }
}