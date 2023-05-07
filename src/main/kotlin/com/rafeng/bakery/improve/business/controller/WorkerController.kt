package com.rafeng.bakery.improve.business.controller

import com.rafeng.bakery.improve.business.model.dto.Worker
import com.rafeng.bakery.improve.business.service.impl.WorkerServiceImpl
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/worker")
class WorkerController(val workerServiceImpl: WorkerServiceImpl) {

    @PostMapping
    fun addWorker(@RequestBody worker: Worker) {
        workerServiceImpl.addItem(worker)
    }

    @DeleteMapping
    fun deleteWorker(worker: Worker) {
        workerServiceImpl.deleteItem(worker)
    }

    @GetMapping
    fun getAllWorkers() {
        workerServiceImpl.getAll()
    }
}