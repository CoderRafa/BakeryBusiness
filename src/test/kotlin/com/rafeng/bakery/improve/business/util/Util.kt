package com.rafeng.bakery.improve.business.util

import com.rafeng.bakery.improve.business.common.generateUniqueStringIdentifier
import com.rafeng.bakery.improve.business.model.Client
import com.rafeng.bakery.improve.business.model.ItemSize
import com.rafeng.bakery.improve.business.model.ItemSmell
import com.rafeng.bakery.improve.business.model.SellItem
import com.rafeng.bakery.improve.business.model.TasteType
import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.Order
import com.rafeng.bakery.improve.business.model.dto.PaymentType.CASH
import com.rafeng.bakery.improve.business.model.dto.Position.SALESPERSON
import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.model.dto.Worker
import com.rafeng.bakery.improve.business.model.dto.updateTotal
import java.time.LocalDateTime
import kotlin.random.Random

fun createRandomItemByRecipe(recipe: Recipe) = Item(
    ('a'..'z').take(Random.nextInt(1, 27)).joinToString(""),
    Random.nextDouble(),
    ItemSize.values()[Random.nextInt(0, ItemSize.values().size - 1)],
    ItemSmell.STRONG,
    TasteType.SWEET,
//    listOf(ItemFilling(Filling("test", "description", FillingType.JAM, TasteType.SWEET), 10.0)),
//    listOf(ItemTopping(Topping("test", "description", ToppingType.CREAM, TasteType.SWEET), 10.0)),
    300,
    listOf(),
    false,
    recipe,
    LocalDateTime.now()
)

fun createRecipe() = Recipe(id = 1, name = "test", description = "description", expirationPeriod = 2, cookingTime = 3.0)

fun createClient() = Client(id = 1, name = "Vasiliy", lastname = "Nikiforov", phoneNumber = "+79155658987")

fun createWorker() = Worker(id = 1, name = "Lena", lastname = "Ivanova", position = SALESPERSON)

fun createRandomOrder(): Order = Order(
    generateUniqueStringIdentifier(),
    mutableListOf(),
    0.0,
    LocalDateTime.now(),
    0.0,
    Worker(
        name = "",
        lastname = "",
        position = SALESPERSON
    ),
    CASH
)

fun Order.sellItems(initialize: (MutableList<SellItem>) -> Unit): Order {
    initialize(this.sellItems)
    this.updateTotal()
    return this
}

fun Order.discountAmount(initialize: () -> Double): Order {
    this.discountAmount = initialize()
    return this
}

fun Order.salesperson(initialize: (Worker) -> Unit): Order {
    val salesPerson = Worker(name = "", lastname = "", position = SALESPERSON)
    initialize(salesPerson)
    this.salesperson = salesPerson
    return this
}
