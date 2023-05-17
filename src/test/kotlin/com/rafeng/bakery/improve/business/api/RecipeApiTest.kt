package com.rafeng.bakery.improve.business.api

import com.rafeng.bakery.improve.business.BakeryBusinessApplication
import com.rafeng.bakery.improve.business.model.dto.Recipe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.EnableTransactionManagement

@ActiveProfiles("h2")
@SpringBootTest(
    classes = [BakeryBusinessApplication::class, LiquibaseH2TestConfig::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class RecipeApiTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    @Order(1)
    fun `Happy pass - save a new recipe to DB`() {
        val recipe = restTemplate.postForEntity(
            "/api/v1/recipe",
            Recipe(name = "Bun", description = "The best bun in the world", expirationPeriod = 1, cookingTime = 2.0),
            Recipe::class.java
        )

        Assertions.assertThat(recipe.statusCode.is2xxSuccessful).isTrue
        checkBaseRecipe(recipe)
    }

    @Test
    @Order(20)
    fun `Happy path - find a recipe by id`() {
        val recipe = restTemplate.getForEntity(
            "/api/v1/recipe/1",
            Recipe::class.java
        )

        Assertions.assertThat(recipe.statusCode.is2xxSuccessful).isTrue
        checkBaseRecipe(recipe)
    }

    private fun checkBaseRecipe(recipe: ResponseEntity<Recipe>) {
        Assertions.assertThat(recipe.body).hasNoNullFieldsOrProperties()
        Assertions.assertThat(recipe.body?.name).isEqualTo("Bun")
        Assertions.assertThat(recipe.body?.description).isEqualTo("The best bun in the world")
        Assertions.assertThat(recipe.body?.expirationPeriod).isEqualTo(1)
        Assertions.assertThat(recipe.body?.cookingTime).isEqualTo(2.0)
    }
}

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan("com.rafeng.bakery.improve.business.model.entity")
@EnableJpaRepositories(basePackages = ["com.rafeng.bakery.improve.business.repository.spring"])
class LiquibaseH2TestConfig