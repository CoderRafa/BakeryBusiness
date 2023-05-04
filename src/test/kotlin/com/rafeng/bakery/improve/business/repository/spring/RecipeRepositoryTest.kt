package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.RecipeEntity
import org.assertj.core.api.Assertions
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

    @Test
    fun `Happy pass - add a new recipe to DB`() {
        val recipeEntity = RecipeEntity()
        recipeEntity.cookingTime = 2.0
        recipeEntity.description = "The best recipe of Bulochka"
        recipeEntity.name = "Bulochka"
        recipeEntity.expirationPeriod = 2

        recipeEntityRepository.save(recipeEntity)

        Assertions.assertThat(recipeEntity.id).isNotNull
    }
}

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan("com.rafeng.bakery.improve.business.model.entity")
@EnableJpaRepositories(basePackages = ["com.rafeng.bakery.improve.business.repository.spring"])
class LiquibaseH2TestConfig