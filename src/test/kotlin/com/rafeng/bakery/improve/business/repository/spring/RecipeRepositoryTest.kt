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
        val recipeEntity = RecipeEntity()
        recipeEntity.cookingTime = 2.0
        recipeEntity.description = "The best recipe of Bulochka"
        recipeEntity.name = "Bulochka"
        recipeEntity.expirationPeriod = 2

        recipeEntityRepository.save(recipeEntity)

        checkNewRecipeEntityFields(recipeEntity)
        checkNewRecipeEntityFields(recipeEntityRepository.findById(recipeEntity.id!!).get())
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
}

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan("com.rafeng.bakery.improve.business.model.entity")
@EnableJpaRepositories(basePackages = ["com.rafeng.bakery.improve.business.repository.spring"])
class LiquibaseH2TestConfig