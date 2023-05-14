package com.rafeng.bakery.improve.business.controller

import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.rafeng.bakery.improve.business.service.impl.ClientService
import com.rafeng.bakery.improve.business.util.createClient
import org.aspectj.apache.bcel.generic.InstructionConstants.Clinit
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(ClientController::class)
class ClientControllerTest @Autowired constructor(private val mockMvc: MockMvc) {

    @MockBean
    lateinit var clientService: ClientService

    @Test
    fun `Happy pass - create a new client in the system`() {
        val client = createClient()

        Mockito.doReturn(client).`when`(clientService).save(client)

        mockMvc.post("/api/v1/client") {
            contentType = MediaType.APPLICATION_JSON
            content = jsonMapper().writeValueAsString(client)
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$.id", Matchers.`is`(1))
        }
    }

    @Test
    fun `Happy pass - get all clients by zero size`() {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/v1/client").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(0))
    }

    @Test
    fun `Happy pass - get all clients by one client`() {
        val client = createClient()
        val clientList = listOf(client)

        Mockito.doReturn(clientList).`when`(clientService).get()

        mockMvc.get("/api/v1/client") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            jsonPath("$.size()", Matchers.`is`(1))
        }
    }

    @Test
    fun `Happy pass - a client was deleted`() {
        val clientList = listOf(createClient())

        Mockito.doReturn(clientList).`when`(clientService).delete(anyLong())

        mockMvc.delete("/api/v1/client/1") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            jsonPath("$.size()", Matchers.`is`(1))
        }
    }

    @Test
    fun `Negative pass - try to achieve the delete method with String param`() {

        mockMvc.delete("/api/v1/client/asdf") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isBadRequest() }
        }
    }
}