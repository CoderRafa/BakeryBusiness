package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.Filling
import com.rafeng.bakery.improve.business.service.impl.FillingService
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
@RequestMapping("/api/v1/filling")
class FillingController(val fillingService: FillingService) {

    private val log = LoggerFactory.getLogger(FillingController::class.java)
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addFilling(@RequestBody filling: Filling): Filling {
        log.debug("Add a new filling")
        return fillingService.save(filling)
    }

    @GetMapping
    fun getFillings(): List<Filling> {
        log.debug("Get all fillings")
        return fillingService.get()
    }

    @DeleteMapping("/{id}")
    fun deleteFilling(@PathVariable("id") id: Long): List<Filling> {
        log.debug("Delete a filling with an Id $id")
        return fillingService.delete(id)
    }

}