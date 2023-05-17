package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.RecipeEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.EnableTransactionManagement


@ActiveProfiles("h2")
@SpringBootTest(classes = [LiquibaseH2TestConfig::class])
class RecipeRepositoryTest @Autowired constructor(
    val recipeEntityRepository: RecipeEntityRepository
) {

    @Order(1)
    @Test
    fun `Happy pass - add a new recipe to DB`() {
        val recipeEntity = createRecipeEntity()

        recipeEntityRepository.save(recipeEntity)

        checkNewRecipeEntityFields(recipeEntity)
        checkNewRecipeEntityFields(recipeEntityRepository.findById(recipeEntity.id!!).get())
    }

    private fun createRecipeEntity(): RecipeEntity {
        return RecipeEntity().apply {
            this.cookingTime = 2.0
            this.description = "The best recipe of Bulochka"
            this.name = "Bulochka"
            this.expirationPeriod = 2
        }
    }

    private fun checkNewRecipeEntityFields(recipeEntity: RecipeEntity) {
        assertThat(recipeEntity.id).isNotNull
        assertThat(recipeEntity.cookingTime).isEqualTo(2.0)
        assertThat(recipeEntity.description).isNotNull
        assertThat(recipeEntity.name).isNotNull
        assertThat(recipeEntity.expirationPeriod).isEqualTo(2)
    }

    @Order(2)
    @Test
    fun `Happy pass - find all recipe in DB`() {
        val recipeEntities = recipeEntityRepository.findAll()
        assertThat(recipeEntities).isNotEmpty
    }

    @Order(3)
    @Test
    fun `Happy pass - a recipe was deleted from DB`() {
        val recipeEntity = createRecipeEntity()
        checkNewRecipeEntityFields(recipeEntityRepository.save(recipeEntity))

        recipeEntityRepository.deleteById(recipeEntity.id!!)
        assertThat(recipeEntityRepository.findById(recipeEntity.id!!)).isEmpty

        assertThat(recipeEntityRepository.findAll()).isEmpty()
    }
}

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan("com.rafeng.bakery.improve.business.model.entity")
@EnableJpaRepositories(basePackages = ["com.rafeng.bakery.improve.business.repository.spring"])
class LiquibaseH2TestConfig