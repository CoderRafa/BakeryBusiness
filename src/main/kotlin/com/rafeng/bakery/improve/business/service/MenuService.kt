package com.rafeng.bakery.improve.business.service

import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.MenuItem

interface MenuService {
    fun addItem(item: Item): Boolean
    fun deleteItem(item: Item): Boolean
    fun getAll(): List<MenuItem>
}