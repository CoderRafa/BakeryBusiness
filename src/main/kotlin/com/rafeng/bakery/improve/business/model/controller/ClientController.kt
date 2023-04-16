package com.rafeng.bakery.improve.business.model.controller

import com.rafeng.bakery.improve.business.model.Client
import com.rafeng.bakery.improve.business.service.impl.ClientServiceImpl
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/client")
class ClientController(val clientServiceImpl: ClientServiceImpl) {

    @PostMapping
    fun addClient(@RequestBody addClientRequest: Client) {
        clientServiceImpl.addItem(addClientRequest)
    }

    @DeleteMapping
    fun deleteClient(@RequestBody deleteClientRequest: Client) {
        clientServiceImpl.deleteItem(deleteClientRequest)
    }

    @GetMapping
    fun getAllClients(): List<Client> {
        return clientServiceImpl.getAll()
    }
}