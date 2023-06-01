package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Ingredient
import com.rafeng.bakery.improve.business.repository.spring.IngredientRepository
import com.rafeng.bakery.improve.business.repository.spring.LiquibaseTestConfig
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.`in`
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("h2")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(classes = [LiquibaseTestConfig::class, IngredientServiceTestConfiguration::class])
class IngredientServiceTest @Autowired constructor (
        val ingredientService: IngredientService
) {

    private val log = LoggerFactory.getLogger(IngredientService::class.java)

    @Order(1)
    @Test
    fun `Happy pass - add an ingredient to the DB`() {
        val ingredient = createIngredient()

        val result = ingredientService.save(ingredient)

        assertThat(result).isNotNull
        assertThat(result.name).isEqualTo("Milk")
        assertThat(result.description).isEqualTo("Whole milk")
        assertThat(result.productionDate).isEqualTo("28.05.2023")
        assertThat(result.expirationDate).isEqualTo("05.06.2023")
    }

    @Order(2)
    @Test
    fun `Happy pass - get all ingredients`() {
        val ingredients = ingredientService.getAll()
        assertThat(ingredients.size).isEqualTo(1)
        assertThat(ingredients.map { it.name }.first()).isEqualTo("Milk")
        assertThat(ingredients.map { it.description}.first()).isEqualTo("Whole milk")
    }


    fun createIngredient(): Ingredient {
        return Ingredient(
            name = "Milk",
            description = "Whole milk",
            productionDate = "28.05.2023",
            expirationDate = "05.06.2023"
        )
    }
}

@TestConfiguration
class IngredientServiceTestConfiguration {

    @Bean
    fun ingredientService(ingredientRepository: IngredientRepository) = IngredientService(ingredientRepository)
}