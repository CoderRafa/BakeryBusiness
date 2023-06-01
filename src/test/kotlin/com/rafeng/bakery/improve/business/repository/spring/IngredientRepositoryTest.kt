package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.IngredientEntity
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("h2")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(classes = [LiquibaseTestConfig::class])
class IngredientRepositoryTest @Autowired constructor (
    val ingredientRepository: IngredientRepository
) {
    @Order(1)
    @Test
    fun `Happy pass - add a new ingredient to the DB`() {
        val ingredientEntity = createIngredientEntity()
        ingredientRepository.save(ingredientEntity)
        assertThat(ingredientEntity.id).isNotNull
    }

    @Order(2)
    @Test
    fun `Happy pass - get all ingredients from DB`() {
        val ingredients = ingredientRepository.findAll()
        assertThat(ingredients).isNotEmpty
    }

    @Order(3)
    @Test
    fun `Happy pass - delete an ingredient by id`() {
        val toBeDeletedIngredient = createIngredientEntity()
        ingredientRepository.save(toBeDeletedIngredient)
        assertThat(ingredientRepository.findAll().map { it.id }).contains(toBeDeletedIngredient.id)
        ingredientRepository.deleteById(toBeDeletedIngredient.id!!)
        assertThat(ingredientRepository.findAll().none { it.id == toBeDeletedIngredient.id })
    }

    private fun createIngredientEntity(): IngredientEntity {
        return IngredientEntity().apply {
            this.name = "Milk"
            this.description = "Whole milk"
            this.productionDate = "28.05.2023"
            this.expirationDate = "05.06.2023"
        }
    }
}