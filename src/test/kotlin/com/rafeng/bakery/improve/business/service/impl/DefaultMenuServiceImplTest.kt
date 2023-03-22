package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Item
import com.rafeng.bakery.improve.business.model.MenuItem
import com.rafeng.bakery.improve.business.service.MenuService
import com.rafeng.bakery.improve.business.service.PriceService
import com.rafeng.bakery.improve.business.util.createRandomItemByRecipe
import com.rafeng.bakery.improve.business.util.createRecipe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class DefaultMenuServiceImplTest {

    @Mock
    private lateinit var priceService: PriceService
    private lateinit var defaultMenuService: MenuService

    @BeforeEach
    fun setUp() {
        defaultMenuService = DefaultMenuServiceImpl(priceService)
    }

    @Test
    fun `Happy pass - an item was added to a menu`() {
        val item = createItemForTest()
        assertTrue(defaultMenuService.addItem(item))
    }

    @Test
    fun `Negative pass - an item wasn't added to a menu`() {
        val item = createItemForTest()
        addItemForTest(item)
        assertFalse(defaultMenuService.addItem(item))
    }

    @Test
    fun `Happy pass - an item was successfully deleted`() {

        val item = createItemForTest()
        `when`(priceService.findPriceBy(item.recipe)).thenReturn(10.0)

        addItemForTest(item)
        assertTrue(defaultMenuService.getAll().size == 1)
        assertTrue(defaultMenuService.deleteItem(item))
        assertTrue(defaultMenuService.getAll().isEmpty())
    }

    @Test
    fun `Negative pass - an item wasn't deleted`() {
        var item_1 = createItemForTest()
        val item_2 = createItemForTest()
        addItemForTest(item_1)
        item_1 = item_2
        assertFalse(defaultMenuService.deleteItem(item_1))
    }

    @Test
    fun `Happy pass - gets all elements`() {
        val items = mutableListOf<Item>()
            (1..7).forEach { items.add(createItemForTest()) }
        for (item in items) {
            `when`(priceService.findPriceBy(item.recipe)).thenReturn(10.0)
            addItemForTest(item)
        }
        assertTrue(defaultMenuService.getAll().size == 7)
        assertTrue(defaultMenuService.getAll().all { it.price == 10.0 } )
        assertTrue(defaultMenuService.getAll().map { it.item }.containsAll(items))
    }

    @Test
    fun `Negative pass - get all with nothing to get`() {
        val items = mutableListOf<Item>()
        (1..7).forEach { items.add(createItemForTest()) }
        for (item in items) {
            `when`(priceService.findPriceBy(item.recipe)).thenReturn(10.0)
            addItemForTest(item)
        }
        val deletedItems = items.take(3)
        for (item in deletedItems) {
            defaultMenuService.deleteItem(item)
        }

       assertFalse(defaultMenuService.getAll().map { it.item }.containsAll(deletedItems))
    }

    fun addItemForTest(item: Item) {
        defaultMenuService.addItem(item)
    }

    fun createItemForTest(): Item {
        return createRandomItemByRecipe(createRecipe())
    }

}