package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Ingredient
import com.rafeng.bakery.improve.business.repository.spring.IngredientRepository
import com.rafeng.bakery.improve.business.repository.spring.LiquibaseTestConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("h2")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(classes = [LiquibaseTestConfig::class, IngredientServiceTestConfiguration::class])
class IngredientServiceTest @Autowired constructor(
        val ingredientService: IngredientService
) {

    private val log = LoggerFactory.getLogger(IngredientService::class.java)

    @Order(0)
    @Test
    fun `Happy pass - make sure that the repository is empty`() {
        val emptyRepository = ingredientService.getAll()
        assertThat(emptyRepository).isEmpty()
    }

    @Order(1)
    @Test
    fun `Happy pass - add an ingredient to the DB`() {
        checkIngredient(ingredientService.save(createIngredient()))
    }

    @Order(2)
    @Test
    fun `Negative pass - add an ingredient with missing name`() {

    }

    @Order(3)
    @Test
    fun `Happy pass - get all ingredients`() {
        val ingredients = ingredientService.getAll()
        assertThat(ingredients.size).isEqualTo(1)
        checkIngredient(ingredients.first())
    }

    @Order(4)
    @Test
    fun `Negative pass - get all without nothing to get`() {
        val toBeDeletedIngredient = createIngredient()
        ingredientService.save(toBeDeletedIngredient)
        ingredientService.getById(toBeDeletedIngredient.id!!)
        assertThat( ingredientService.getAll().contains(toBeDeletedIngredient).not() )
    }

    @Order(5)
    @Test
    fun `Happy pass - get an ingredient by id`() {
        val firstIngredient = ingredientService.getById(1)
        assertThat(firstIngredient.id).isEqualTo(1)
        checkIngredient(firstIngredient)
    }

    @Order(6)
    @Test
    fun`Negative pass - get a deleted ingredient by id`() {
        ingredientService.delete(1)
        ingredientService.getById(1)
    }

    private fun checkIngredient(result: Ingredient) {
        assertThat(result).isNotNull
        assertThat(result.name).isEqualTo("Milk")
        assertThat(result.description).isEqualTo("Whole milk")
        assertThat(result.productionDate).isEqualTo("28.05.2023")
        assertThat(result.expirationDate).isEqualTo("05.06.2023")
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