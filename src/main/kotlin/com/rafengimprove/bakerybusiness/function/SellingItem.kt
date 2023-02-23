package com.rafengimprove.bakerybusiness.function

import com.rafengimprove.bakerybusiness.model.SellingItem

var revenue = 0.0

fun sellingItem(index: Int, menu: MutableList<SellingItem>, amount: Int) {

    revenue += menu[index].price * amount
    menu[index].amount -= amount

}

fun main() {
    val menu = createBakeryMenu(20)

    println("amount before sale = ${menu[2].amount}")
    println("amount before sale = ${menu[3].amount}")
    println("amount before sale = ${menu[1].amount}")

    println("revenue before sale = $revenue")

    sellingItem(2, menu, 1)
    sellingItem(3, menu, 1)
    sellingItem(1, menu, 1)

    println("amount after sale = ${menu[2].amount}")
    println("amount after sale = ${menu[3].amount}")
    println("amount after sale = ${menu[1].amount}")

    println("price1 = ${menu[2].price} price2 = ${menu[3].price} price3 = ${menu[1].price}")
    println("revenue after sale = $revenue")
}