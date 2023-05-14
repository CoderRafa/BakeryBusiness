package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.Client
import com.rafeng.bakery.improve.business.service.impl.ClientService
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/client")
class ClientController(val clientService: ClientService) {
    private val log = LoggerFactory.getLogger(ClientController::class.java)

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addClient(@RequestBody client: Client): Client {
        log.debug("Add new client")
        return clientService.save(client)
    }

    @GetMapping
    fun getAllClients(): List<Client> {
        log.debug("Get all clients")
        return clientService.get()
    }

    @DeleteMapping("/{id}")
    fun deleteClient(@PathVariable("id") id: Long): List<Client> {
        log.debug("Delete a client with ID $id")
        return clientService.delete(id)
    }
}

