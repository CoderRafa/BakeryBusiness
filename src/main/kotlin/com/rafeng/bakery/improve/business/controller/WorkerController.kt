package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.dto.Worker
import com.rafeng.bakery.improve.business.service.impl.WorkerService
import com.rafeng.bakery.improve.business.service.impl.WorkerServiceImpl
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/worker")
class WorkerController(val workerService: WorkerService) {

    private val log = LoggerFactory.getLogger(WorkerController::class.java)

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addWorker(@RequestBody worker: Worker): Worker {
        log.debug("Add ne worker")
        return workerService.save(worker)
    }

    @GetMapping()
    fun getAllWorkers(): List<Worker> {
        log.debug("Get all workers")
        return workerService.get()
    }

    @DeleteMapping("/{id}")
    fun deleteWorker(@PathVariable("id") id: Long): List<Worker> {
        log.debug("Delete a worker with an Id $id")
        return workerService.delete(id)
    }

}