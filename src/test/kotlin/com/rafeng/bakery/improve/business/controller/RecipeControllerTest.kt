package com.rafeng.bakery.improve.business.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.rafeng.bakery.improve.business.model.dto.Recipe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ActiveProfiles("h2")
@WebMvcTest(RecipeController::class)
class RecipeControllerTest @Autowired constructor(private val mockMvc: MockMvc) {

    @Test
    fun `Happy pass - create a new recipe in the system`() {
        mockMvc.perform(
            post("/api/v1/recipe")
                .content(
                    ObjectMapper().writeValueAsString(
                        Recipe(
                            name = "Bun",
                            description = "The best bun in the world",
                            expirationPeriod = 1,
                            cookingTime = 2.0
                        )
                    )
                ).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
    }
}