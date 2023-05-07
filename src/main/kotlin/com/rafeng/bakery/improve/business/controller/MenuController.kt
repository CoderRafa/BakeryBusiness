package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.service.impl.MenuServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/menu")
class MenuController(val menuServiceImpl: MenuServiceImpl) {

    @PostMapping
    fun addItem(@RequestBody item: Item) {
        menuServiceImpl.addItem(item)
    }

    @DeleteMapping
    fun deleteItem(item: Item) {
        menuServiceImpl.deleteItem(item)
    }

    @GetMapping
    fun getAllItems() {
        menuServiceImpl.getAllMenuItems()
    }

}