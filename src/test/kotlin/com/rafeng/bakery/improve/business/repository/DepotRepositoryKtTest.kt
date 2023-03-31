package com.rafeng.bakery.improve.business.repository

import com.rafeng.bakery.improve.business.model.*
import com.rafeng.bakery.improve.business.model.dto.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDateTime
import kotlin.random.Random
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextInt

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
    fun `Happy pass - an item was added to the list of orders`() {
        assertEquals(2,  depotRepo.getAll().size)
        depotRepo.save(recipe3, 6)
        assertEquals(3,  depotRepo.getAll().size)
    }

    @Test
    fun `Happy pass - an order was successfully deleted`() {
        assertEquals(2,  depotRepo.getAll().size)
        depotRepo.save(recipe3, 4)
        assertEquals(3,  depotRepo.getAll().size)
        depotRepo.delete(recipe3)
        assertEquals(2,  depotRepo.getAll().size)
    }

    @Test
    fun `Happy pass - get all the orders from the mutable list`() {
        assertEquals(2, depotRepo.getAll().size)
        depotRepo.save(recipe3, 4)
        assertEquals(3, depotRepo.getAll().size)
    }
}