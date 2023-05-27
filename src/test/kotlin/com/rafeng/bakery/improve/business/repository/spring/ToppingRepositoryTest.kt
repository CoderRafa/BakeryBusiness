package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.TasteType.SWEET
import com.rafeng.bakery.improve.business.model.ToppingType.*
import com.rafeng.bakery.improve.business.model.entity.ItemToppingEntity
import com.rafeng.bakery.improve.business.model.entity.ToppingEntity
import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
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
class ToppingRepositoryTest @Autowired constructor(
    val toppingEntityRepository: ToppingEntityRepository,
    val itemToppingEntityRepository: ItemToppingEntityRepository
) {
    @Test
    @Order(1)
    fun `Happy pass - add a new topping to the DB`() {
        val toppingEntity = createToppingEntity()
        toppingEntityRepository.save(toppingEntity)
        assertThat(toppingEntity.id).isNotNull
        assertThat(toppingEntity.itemToppings).isNotEmpty
    }

    @Test
    @Order(2)
    @Transactional
    fun `Happy pass - check item topping record`() {
        val itemToppingEntities = itemToppingEntityRepository.findAll()
        assertThat(itemToppingEntities).isNotEmpty
        assertThat(itemToppingEntities.first().toppings).isNotEmpty
    }

    @Test
    @Order(3)
    fun `Happy pass - get all toppings from the DB`() {
        val toppingEntities = toppingEntityRepository.findAll()
        assertThat(toppingEntities).isNotEmpty
    }

    @Test
    @Order(4)
    fun `Happy pass - delete a topping from the DB`() {
        val toppingEntityToBeDeleted = createToppingEntity()
        toppingEntityRepository.save(toppingEntityToBeDeleted)
        assertThat(toppingEntityRepository.findAll().map { it.id }).contains(toppingEntityToBeDeleted.id)
        toppingEntityRepository.deleteById(toppingEntityToBeDeleted.id!!)
        assertFalse((toppingEntityRepository.findAll().map { it.id }).contains(toppingEntityToBeDeleted.id))
    }

    private fun createToppingEntity(): ToppingEntity {
        return ToppingEntity().apply {
            this.name = "Caramel"
            this.description = "Tasty caramel"
            this.toppingType = LIQUID
            this.tasteType = SWEET
            this.itemToppings = createItemToppingEntities()
        }
    }

    private fun createItemToppingEntities(): List<ItemToppingEntity> {
        return listOf(ItemToppingEntity().apply {
            this.name = "Caramel"
            this.weight = 10.0
            this.ratio = 1.5F
            this.description = "Nice caramel"
        })
    }

}