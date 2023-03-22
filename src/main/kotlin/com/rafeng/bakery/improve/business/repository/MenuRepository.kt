package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.dto.Item

data class MenuRepository(val menuItems: MutableSet<Item> = mutableSetOf())