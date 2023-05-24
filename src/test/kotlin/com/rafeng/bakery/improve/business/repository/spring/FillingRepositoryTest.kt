package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.*
import com.rafeng.bakery.improve.business.model.FillingType.*
import com.rafeng.bakery.improve.business.model.TasteType.SWEET
import com.rafeng.bakery.improve.business.model.entity.FillingEntity
import com.rafeng.bakery.improve.business.model.entity.ItemFillingEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@ActiveProfiles("h2")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(classes = [LiquibaseTestConfig::class])
class FillingRepositoryTest @Autowired constructor(
    val fillingEntityRepository: FillingEntityRepository,
    val itemFillingEntityRepository: ItemFillingEntityRepository
) {
    @Order(1)
    @Test
    fun `Happy pass - add a new filling to DB`() {
        val fillingEntity = createFillingEntity()
        fillingEntityRepository.save(fillingEntity)
        assertThat(fillingEntity.id).isNotNull
        assertThat(fillingEntity.itemFillings).isNotEmpty
    }

    @Order(2)
    @Test
    @Transactional
    fun `Happy pass - check item filling record`() {
        val itemFillingEntities = itemFillingEntityRepository.findAll()
        assertThat(itemFillingEntities).isNotEmpty
        assertThat(itemFillingEntities.first().fillings).isNotEmpty
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
        return listOf(ItemFillingEntity().apply {
            this.name = "Straw"
            this.weight = 20.0
            this.ratio = 2F
            this.description = "It is sweet"
        })
    }
}