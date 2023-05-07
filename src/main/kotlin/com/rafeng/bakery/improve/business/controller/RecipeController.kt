package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.impl.RecipeService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/recipe")
class RecipeController(private val recipeService: RecipeService) {
    private val log = LoggerFactory.getLogger(RecipeController::class.java)

    @PostMapping
    fun add(@RequestBody recipe: Recipe): Recipe {
        log.debug("Add new recipe")
        return recipeService.save(recipe)
    }
}