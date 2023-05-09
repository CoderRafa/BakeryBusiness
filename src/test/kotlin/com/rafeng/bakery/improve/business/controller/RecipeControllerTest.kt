package com.rafeng.bakery.improve.business.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.service.impl.RecipeService
import com.rafeng.bakery.improve.business.util.createRecipe
import org.hamcrest.collection.IsCollectionWithSize.hasSize
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.MediaType
import org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

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
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{}") }
        }

//        mockMvc.perform(
//            post("/api/v1/recipe")
//                .content(
//                    ObjectMapper().writeValueAsString(
//                        recipe
//                    )
//                ).contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//        )
//            .andExpect(MockMvcResultMatchers.status().isOk)
//            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
    }


    @Test
    fun `Happy pass - get all recipes`() {
        val recipe = createRecipe()
        Mockito.doReturn(recipe).`when`(recipeService).save(recipe)

        mockMvc.get("/api/v1/recipe") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            MockMvcResultMatchers.jsonPath("$.size()").value(0)
        }

        mockMvc.post("/api/v1/recipe") {
            contentType = MediaType.APPLICATION_JSON
            content = jsonMapper().writeValueAsString(recipe)
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{}") }
        }

        mockMvc.get("/api/v1/recipe") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            MockMvcResultMatchers.jsonPath("$.size()").value(1)
        }
    }

    @Test
    fun `Happy pass - a recipe was deleted`() {
        val recipe = createRecipe()
        val recipeList = listOf(recipe)

        Mockito.doReturn(recipe).`when`(recipeService).save(recipe)
        Mockito.doReturn(recipeList).`when`(recipeService).delete(recipe.id!!)

        mockMvc.post("/api/v1/recipe") {
            contentType = MediaType.APPLICATION_JSON
            content = jsonMapper().writeValueAsString(recipe)
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{}") }
        }

        mockMvc.get("/api/v1/recipe") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            MockMvcResultMatchers.jsonPath("$.size()").value(1)
        }

        mockMvc.delete("/api/v1/recipe", recipe.id) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            MockMvcResultMatchers.jsonPath("$.size()").value(0)
        }
        
    }

}