package com.rafeng.bakery.improve.business.algoriphmics

fun noDuplicates(list: List<Int>): Boolean {
    val sortedList = list.sorted()
    for (item in 1 until sortedList.size) {
        if (sortedList[item - 1] == sortedList[item])
            return false
    }
    return true
}

fun noDuplicatesWithDistinct(list: List<Int>): Boolean {
    return list.size == list.distinct().size
}

fun main() {
    println(noDuplicates(listOf(1, 2, 3, 3, 4, 5)))
    println(noDuplicatesWithDistinct(listOf(1, 2, 3, 4, 5)))
}