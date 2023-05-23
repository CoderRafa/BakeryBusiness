package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.*
import com.rafeng.bakery.improve.business.model.FillingType.*
import com.rafeng.bakery.improve.business.model.TasteType.SWEET
import com.rafeng.bakery.improve.business.model.entity.FillingEntity
import com.rafeng.bakery.improve.business.model.entity.ItemFillingEntity
import com.rafeng.bakery.improve.business.model.entity.ToppingEntity
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("h2")
@SpringBootTest(classes = [LiquibaseH2TestConfig::class])
class FillingRepositoryTest @Autowired constructor(
        val fillingEntityRepository: FillingEntityRepository
) {
    @Order(1)
    @Test
    fun `Happy pass - add a new filling to DB`() {
        val fillingEntity = createFillingEntity()
    }

    private fun createFillingEntity(): FillingEntity {
        return FillingEntity().apply {
            this.name = "Sweet straw"
            this.description = "Very sweet topping"
            this.fillingType = LIQUID
            this.tasteType = SWEET
            this.itemFillings = createItemFillingEntities()
        }
    }

    private fun createItemFillingEntities(): List<ItemFillingEntity> {
        return listOf( ItemFillingEntity(
            name = "Straw",
            weight = 20.0,
            ratio = 2F,
            description = "It is sweet",
            filling = listOf(
                    Filling(
                            name = "Cool straw",
                            description = "Really cool straw",
                            fillingType = LIQUID,
                            tasteType = SWEET
                    ).toEntity()
                )
            )
        )
    }
}