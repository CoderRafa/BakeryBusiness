package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.controller.RecipeController
import com.rafeng.bakery.improve.business.repository.spring.LiquibaseH2TestConfig
import org.hamcrest.collection.IsCollectionWithSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.EnableTransactionManagement

@WebMvcTest(RecipeController::class)
@ActiveProfiles("h2")
@SpringBootTest(classes = [LiquibaseH2TestConfig::class])
class RecipeControllerTest @Autowired constructor(val mockMvc: MockMvc) {

    @Test
    fun `Happy pass - create a new recipe in the system`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/recipe"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize<Int>(1)))
    }
}

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan("com.rafeng.bakery.improve.business.model.entity")
@EnableJpaRepositories(basePackages = ["com.rafeng.bakery.improve.business.repository.spring"])
class LiquibaseH2TestConfig