package com.rafeng.bakery.improve.business.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.rafeng.bakery.improve.business.service.impl.RecipeService
import com.rafeng.bakery.improve.business.util.createRecipe
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(RecipeController::class)
class RecipeControllerTest @Autowired constructor(private val mockMvc: MockMvc) {

    @MockBean
    lateinit var recipeService: RecipeService

    @Test
    fun `Happy pass - create a new recipe in the system`() {
        val recipe = createRecipe()
        Mockito.doReturn(recipe).`when`(recipeService).save(recipe)
        mockMvc.perform(
            post("/api/v1/recipe")
                .content(
                    ObjectMapper().writeValueAsString(
                        recipe
                    )
                ).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
    }
}