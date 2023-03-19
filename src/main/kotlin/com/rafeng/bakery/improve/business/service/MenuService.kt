package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.Item
import com.rafeng.bakery.improve.business.model.MenuItem

interface MenuService {
    fun addItem(item: Item): Boolean
    fun deleteItem(item: Item): Boolean
    fun getAll(): List<MenuItem>
}