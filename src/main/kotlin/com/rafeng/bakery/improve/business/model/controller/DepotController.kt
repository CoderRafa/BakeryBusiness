package com.rafeng.bakery.improve.business.model.controller

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.repository.DepotRepository
import com.rafeng.bakery.improve.business.service.DepotService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/depot")
class DepotController(val depotService: DepotService) {
    @PostMapping
    fun addItemToDepot(@RequestBody addItemRequest: AddItemRequest) {
        depotService.addItem(addItemRequest.recipe, addItemRequest.amount)
    }

    @DeleteMapping
    fun deleteItemFromDepot(deleteItemRequest: Recipe) {
        depotService.deleteItem(deleteItemRequest)
    }

    @GetMapping
    fun getAllItemsFromDepot(): Map<Recipe, Int> {
        return depotService.gelAll()
    }
}

class AddItemRequest(
    val recipe: Recipe,
    val amount: Int
)