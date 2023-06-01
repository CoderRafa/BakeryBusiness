package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Ingredient
import com.rafeng.bakery.improve.business.repository.spring.LiquibaseTestConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("h2")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(classes = [LiquibaseTestConfig::class])
class IngredientServiceTest @Autowired constructor (
        val ingredientService: IngredientService
) {

    private val log = LoggerFactory.getLogger(IngredientService::class.java)

    @Test
    fun `Happy pass - add an ingredient to the DB`() {
        val ingredient = createIngredient()

        val result = ingredientService.save(ingredient)

        assertThat(result).isNotNull
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