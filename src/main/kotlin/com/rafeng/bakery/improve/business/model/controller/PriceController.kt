package com.rafeng.bakery.improve.business.model.controller

import com.rafeng.bakery.improve.business.model.dto.CreatePriceForRecipeRequest
import com.rafeng.bakery.improve.business.service.PriceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/price")
class PriceController(val priceService: PriceService) {
    @PostMapping
    fun addPriceForRecipe(@RequestBody createPriceForRecipeRequest: CreatePriceForRecipeRequest) {
        priceService.addPriceFor(createPriceForRecipeRequest.recipeId, createPriceForRecipeRequest.price)
    }

    @GetMapping
    fun getPriceForRecipe(id: String) = priceService.findPriceBy(id)
}

