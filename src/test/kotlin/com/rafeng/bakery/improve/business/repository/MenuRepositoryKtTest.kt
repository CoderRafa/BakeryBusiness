package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.repository.impl.MenuRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MenuRepositoryKtTest { 

    private lateinit var menuRepo: MenuRepository
    private val recipe = Recipe("test", "super test", 2, 2.15)
    @BeforeEach
    fun setUp() {
        menuRepo = MenuRepository()
        menuRepo.save(createRandomItemByRecipe(recipe))
        menuRepo.save(createRandomItemByRecipe(recipe))
    }

    @Test
    fun `Happy pass - an order was added to the list of orders`() {
        val item = createRandomItemByRecipe(recipe)
        assertEquals(2,  menuRepo.getAll().size)
        menuRepo.save(item)
        assertEquals(3,  menuRepo.getAll().size)
    }

    @Test
    fun `Happy pass - an order was successfully deleted`() {
        val item = createRandomItemByRecipe(recipe)
        assertEquals(2,  menuRepo.getAll().size)
        menuRepo.save(item)
        assertEquals(3,  menuRepo.getAll().size)
        menuRepo.delete(item)
        assertEquals(2,  menuRepo.getAll().size)
    }

    @Test
    fun `Happy pass - get all the orders from the mutable list`() {
        assertEquals(2, menuRepo.getAll().size)
        menuRepo.save(createRandomItemByRecipe(recipe))
        menuRepo.save(createRandomItemByRecipe(recipe))
        assertEquals(4, menuRepo.getAll().size)
    }
}