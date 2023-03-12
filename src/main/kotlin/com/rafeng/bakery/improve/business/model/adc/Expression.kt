package com.rafeng.bakery.improve.business.model.adc

import org.springframework.http.HttpStatus

sealed interface Expression

class Num(val value: Int) : Expression
class Sum(val firstValue: Num, val secondValue: Num) : Expression
class Multiply(val firstValue: Num, val secondValue: Num) : Expression


fun doSomethingGood(expression: Expression) = when (expression) {
    is Num -> println("Value is: ${expression.value}")
    is Sum -> println("Value is: ${expression.firstValue.value + expression.secondValue.value}")
    is Multiply -> println("Value is: ${expression.firstValue.value * expression.secondValue.value}")
}

// Find by id
// Find by name
// NotFoundException

// Merge two different objects to a result
// MergeNotPossibleException

sealed class BakeryBaseException(val code: HttpStatus, val message: String, val description: String)
class BakeryNotFoundException() : BakeryBaseException(HttpStatus.NOT_FOUND, "", "")
class MergeNotPossibleException(val whatIsGoingWrong: String) : BakeryBaseException(HttpStatus.NOT_MODIFIED, "", "")

data class MessageResponse(
    val code: HttpStatus,
    val message: String,
    val description: String,
    val values: MutableMap<Any, Any>
)

fun BakeryBaseException.creatMessageResponse() =
    MessageResponse(this.code, this.message, this.description, mutableMapOf())

class GlobalExceptionHandler() {
    fun handleException(bakeryBaseException: BakeryBaseException) = when (bakeryBaseException) {
        is BakeryNotFoundException -> bakeryBaseException.creatMessageResponse()

        is MergeNotPossibleException -> bakeryBaseException.creatMessageResponse()
            .apply { values["reason"] = bakeryBaseException.whatIsGoingWrong }
    }
    fun handleException(bakeryBaseException: Exception) {

    }
}