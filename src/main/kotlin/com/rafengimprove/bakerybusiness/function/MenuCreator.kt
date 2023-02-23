package com.rafengimprove.bakerybusiness.function

import com.rafengimprove.bakerybusiness.model.SellingItem

fun createBakeryMenu(amount: Int): MutableList<SellingItem> {
    val menu = mutableListOf<SellingItem>()
    (1..amount).forEach { menu.add(createRandomSellingItem()) }
    return menu
}

