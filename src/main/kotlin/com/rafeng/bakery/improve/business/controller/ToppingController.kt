package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.Topping
import com.rafeng.bakery.improve.business.service.spring.ToppingService
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/topping")
class ToppingController(val toppingService: ToppingService) {

    private val log = LoggerFactory.getLogger(ToppingController::class.java)

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addTopping(@RequestBody topping: Topping): Topping {
        log.debug("Add a new topping")
        return toppingService.save(topping)
    }

    @GetMapping
    fun getToppings(): List<Topping> {
        log.debug("Get all toppings")
        return toppingService.get()
    }

    @DeleteMapping("/{id}")
    fun deleteTopping(@PathVariable("id") id: Long): List<Topping> {
        log.debug("Delete a topping with an Id $id")
        return toppingService.delete(id)
    }
}