package com.rafeng.bakery.improve.business.controller

import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.rafeng.bakery.improve.business.service.impl.WorkerService
import com.rafeng.bakery.improve.business.util.createWorker
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(WorkerController::class)
class WorkerControllerTest @Autowired constructor(private val mockMvc: MockMvc) {

    @MockBean
    lateinit var workerService: WorkerService

    @Test
    fun `Happy pass - a new worker was added`() {
        val worker = createWorker()

        Mockito.doReturn(worker).`when`(workerService).save(worker)

        mockMvc.post("/api/v1/worker") {
            contentType = MediaType.APPLICATION_JSON
            content = jsonMapper().writeValueAsString(worker)
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$.id", Matchers.`is`(1))
        }
    }

    @Test
    fun `Happy pass - get all workers by zero size`() {
        mockMvc.get("/api/v1/worker") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
        }
    }

    @Test
    fun `Happy pass - get all workers with one worker`() {
        val worker = createWorker()
        val workerList = listOf(worker)

        Mockito.doReturn(workerList).`when`(workerService).get()

        mockMvc.get("/api/v1/worker") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            jsonPath("$.size()", Matchers.`is`(1))
        }
    }

    @Test
    fun `Happy pass - to delete a worker was passed an id of Long type`() {

        val worker = listOf(createWorker())

        Mockito.doReturn(worker).`when`(workerService).delete(anyLong())

        mockMvc.delete("/api/v1/worker/1") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            jsonPath("$.size()", Matchers.`is`(1))
        }
    }

    @Test
    fun `Happy pass - to delete a worker was passed an id of String type`() {

        mockMvc.delete("/api/v1/worker/asdf") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isBadRequest() }
        }
    }
}