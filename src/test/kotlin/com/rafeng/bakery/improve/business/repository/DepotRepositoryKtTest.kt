package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.repository.impl.DepotRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class depotRepositoryKtTest {

    private lateinit var depotRepo: DepotRepository
    private val recipe1 = Recipe("test", "super test", 2, 2.15)
    private val recipe2 = Recipe("test2", "super test2", 4, 1.0)
    private val recipe3 = Recipe("test3", "super test3", 6, 2.0)
    @BeforeEach
    fun setUp() {
        depotRepo = DepotRepository()
        depotRepo.save(recipe1, 4)
        depotRepo.save(recipe2, 2)
    }

    @Test
    fun `Happy pass - an item was added to the depot`() {
        assertEquals(2,  depotRepo.getAll().size)
        depotRepo.save(recipe3, 6)
        assertEquals(3,  depotRepo.getAll().size)
    }

    @Test
    fun `Happy pass - an item was successfully deleted`() {
        assertEquals(2,  depotRepo.getAll().size)
        depotRepo.save(recipe3, 4)
        assertEquals(3,  depotRepo.getAll().size)
        depotRepo.delete(recipe3)
        assertEquals(2,  depotRepo.getAll().size)
    }

    @Test
    fun `Happy pass - get all the items from depot`() {
        assertEquals(2, depotRepo.getAll().size)
        depotRepo.save(recipe3, 4)
        assertEquals(3, depotRepo.getAll().size)
    }
}