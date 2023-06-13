package com.rafeng.bakery.improve.business.controller

import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.rafeng.bakery.improve.business.service.spring.RecipeService
import com.rafeng.bakery.improve.business.util.createRecipe
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@WebMvcTest(RecipeController::class)
class RecipeControllerTest @Autowired constructor(private val mockMvc: MockMvc) {

    @MockBean
    lateinit var recipeService: RecipeService

    @Test
    fun `Happy pass - create a new recipe in the system`() {
        val recipe = createRecipe()

        Mockito.doReturn(recipe).`when`(recipeService).save(recipe)

        mockMvc.post("/api/v1/recipe") {
            contentType = MediaType.APPLICATION_JSON
            content = jsonMapper().writeValueAsString(recipe)
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$.id", Matchers.`is`(1))
        }
    }


    @Test
    fun `Happy pass - get all recipes by zero size`() {
        mockMvc
            .perform(get("/api/v1/recipe").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(0))
    }

    @Test
    fun `Happy pass - get all recipes by one recipe`() {
        val recipe = createRecipe()
        val recipeList = listOf(recipe)

        Mockito.doReturn(recipeList).`when`(recipeService).get()

        mockMvc.get("/api/v1/recipe") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            jsonPath("$.size()", Matchers.`is`(1))
        }
    }

    @Test
    fun `Happy pass - a recipe was deleted`() {
        val recipeList = mutableListOf(createRecipe())

        Mockito.doReturn(recipeList).`when`(recipeService).delete(anyLong())

        mockMvc.delete("/api/v1/recipe/1") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            jsonPath("$.size()", Matchers.`is`(1))
        }

    }

    @Test
    fun `Negative pass - try to achieve the delete method with String param`() {
        mockMvc.delete("/api/v1/recipe/sdfsdf") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isBadRequest() }
        }

    }

//    Unit
//    Component
//    Integration
//    API test
}