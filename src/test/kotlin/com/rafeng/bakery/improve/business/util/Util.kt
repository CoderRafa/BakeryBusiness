package com.rafeng.bakery.improve.business.util

import com.rafeng.bakery.improve.business.model.*
import com.rafeng.bakery.improve.business.model.dto.Item
import com.rafeng.bakery.improve.business.model.dto.Recipe
import java.time.LocalDateTime
import kotlin.random.Random

fun createRandomItemByRecipe(recipe: Recipe): Item {

    return Item(
        ('a'..'z').take(Random.nextInt(1,27)).joinToString ( "" ),
        Random.nextDouble(),
        ItemSize.values()[Random.nextInt(0, ItemSize.values().size - 1)],
        ItemSmell.STRONG,
        Taste.SWEET,
        listOf(ItemFilling(Filling("test", "description", FillingType.JAM, Taste.SWEET), 10.0 )),
        listOf(ItemTopping(Topping("test", "description", ToppingType.CREAM, Taste.SWEET), 10.0 )),
        300,
        listOf(),
        false,
        recipe,
        LocalDateTime.now()
    )

}

fun createRecipe() = Recipe("test", "description", 2, 3.0)