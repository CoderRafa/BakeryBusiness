package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.service.PriceService
import com.rafeng.bakery.improve.business.util.createRandomItemByRecipe
import com.rafeng.bakery.improve.business.util.createRecipe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MenuServiceImplTestRepository {

    @Mock
    private lateinit var priceService: PriceService
    private lateinit var defaultDefaultService: MenuServiceImpl

    @BeforeEach
    fun setUp() {
        defaultDefaultService = MenuServiceImpl(priceService)
    }

    @Test
    fun `Happy pass - an item was added to a menu`() {
        val item = createItemForTest()
        assertTrue(defaultDefaultService.addItem(item))
    }

    @Test
    fun `Negative pass - an item wasn't added to a menu`() {
        val item = createItemForTest()
        addItemForTest(item)
        assertFalse(defaultDefaultService.addItem(item))
    }

    @Test
    fun `Happy pass - an item was successfully deleted`() {

        val item = createItemForTest()

        addItemForTest(item)
        assertTrue(defaultDefaultService.getAll().size == 1)
        assertTrue(defaultDefaultService.deleteItem(item))
        assertTrue(defaultDefaultService.getAll().isEmpty())
    }

    @Test
    fun `Negative pass - an item wasn't deleted`() {
        var item_1 = createItemForTest()
        val item_2 = createItemForTest()
        addItemForTest(item_1)
        item_1 = item_2
        assertFalse(defaultDefaultService.deleteItem(item_1))
    }

    @Test
    fun `Happy pass - gets all elements`() {
        val items = mutableListOf<Item>()
        (1..7).forEach { items.add(createItemForTest()) }
        for (item in items) {
            `when`(priceService.findPriceBy(item.recipe.id!!)).thenReturn(10.0)
            addItemForTest(item)
        }
        assertTrue(defaultDefaultService.getAllMenuItems().size == 7)
        assertTrue(defaultDefaultService.getAllMenuItems().all { it.price == 10.0 })
        assertTrue(defaultDefaultService.getAllMenuItems().map { it.item }.containsAll(items))
    }

    @Test
    fun `Negative pass - get all with nothing to get`() {
        val items = mutableListOf<Item>()
        (1..7).forEach { items.add(createItemForTest()) }
        for (item in items) {
            addItemForTest(item)
        }
        val deletedItems = items.take(3)
        for (item in deletedItems) {
            defaultDefaultService.deleteItem(item)
        }

        assertFalse(defaultDefaultService.getAllMenuItems().map { it.item }.containsAll(deletedItems))
    }

    fun addItemForTest(item: Item) {
        defaultDefaultService.addItem(item)
    }

    fun createItemForTest(): Item {
        return createRandomItemByRecipe(createRecipe())
    }

}