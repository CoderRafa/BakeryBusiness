package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.spring.RecipeService
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/recipe")
class RecipeController(private val recipeService: RecipeService) {
    private val log = LoggerFactory.getLogger(RecipeController::class.java)

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun add(@RequestBody recipe: Recipe): Recipe {
        log.debug("Add new recipe")
        return recipeService.save(recipe)
    }

    @GetMapping
    fun get(): List<Recipe> {
        log.debug("Get all recipes")
        return recipeService.get()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): Recipe {
        log.debug("Get all recipes")
        return recipeService.get(id)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): List<Recipe> {
        log.debug("Delete a recipe with ID $id")
        return recipeService.delete(id)
    }
}