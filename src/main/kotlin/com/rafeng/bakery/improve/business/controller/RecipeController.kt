package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.impl.RecipeService
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/recipe", consumes = [MediaType.APPLICATION_JSON_VALUE])
class RecipeController(private val recipeService: RecipeService) {
    private val log = LoggerFactory.getLogger(RecipeController::class.java)

    @PostMapping
    fun add(@RequestBody recipe: Recipe): Recipe {
        log.debug("Add new recipe")
        return recipeService.save(recipe)
    }

    @GetMapping
    fun get(): List<Recipe> {
        return recipeService.get()
    }

    @DeleteMapping
    fun delete(@RequestBody id: Long): List<Recipe> {
        return recipeService.delete(id)
    }
}