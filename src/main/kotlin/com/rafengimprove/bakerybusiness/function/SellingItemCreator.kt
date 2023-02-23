package com.rafengimprove.bakerybusiness.function

import com.rafengimprove.bakerybusiness.model.*
import org.apache.tomcat.util.IntrospectionUtils
import java.time.LocalDate
import java.util.*
import kotlin.math.roundToInt

fun sellingItemCreator(item: Item, expirationDate: LocalDate, amount: Int, price: Double): SellingItem {
    return SellingItem(
        item.name,
        item.weight,
        item.size,
        item.smell,
        item.taste,
        item.filling,
        item.topping,
        item.calories,
        item.allergens,
        item.isVegan,
        expirationDate,
        amount,
        price
    )
}

fun createRandomSellingItem(): SellingItem {
    return sellingItemCreator(
        Item(
            name = nameGenerator(),
            weight = (Random().nextDouble(100.0, 500.0)*100.0).roundToInt() / 100.0,
            size = ItemSize.values()[Random().nextInt(1, 3)],
            smell = ItemSmell.values()[Random().nextInt(1, 3)],
            taste = Taste.values()[Random().nextInt(1, 4)],
            filling = listOf(
                ItemFilling(
                    Filling(
                        name = nameGenerator(),
                        description = descriptionGenerator(),
                        type = FillingType.values()[Random().nextInt(1, 3)],
                        taste = Taste.values()[Random().nextInt(1, 4)]
                    ),
                    weight = (Random().nextDouble(50.0, 90.0)*100.0).roundToInt() / 100.0
                )
            ),
            topping = listOf(
                ItemTopping(
                     Topping(
                         name = nameGenerator(),
                         description = descriptionGenerator(),
                         type = ToppingType.values()[Random().nextInt(1, 3)],
                         taste = Taste.values()[Random().nextInt(1, 4)]
                     ),
                    weight = (Random().nextDouble(10.0, 30.0)*100.0).roundToInt() / 100.0
                )
            ),
            calories = Random().nextInt(100, 300),
            allergens = listOf( Allergen.values()[Random().nextInt(1,3)] ),
            isVegan = Random().nextBoolean()
        ),
        expirationDate = LocalDate.now(),
        amount = Random().nextInt(0, 50),
        price = (Random().nextDouble(20.0, 150.0)*100.0).roundToInt() / 100.0
    )
}

fun nameGenerator(): String {
    var name = ""
    for (i in 1..Random().nextInt(5, 9)) {
        name += ('a'..'z').random()
    }
    return (IntrospectionUtils.capitalize(name))
}

fun descriptionGenerator(): String {
    var description = ""
    for (i in 1..Random().nextInt(30, 50)) {
        description += ('a'..'z').random()
    }
    return (IntrospectionUtils.capitalize(description))
}