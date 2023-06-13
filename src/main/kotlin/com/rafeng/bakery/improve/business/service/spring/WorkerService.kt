package com.rafeng.bakery.improve.business.service.spring

import com.rafeng.bakery.improve.business.model.dto.Worker
import com.rafeng.bakery.improve.business.model.dto.toEntity
import com.rafeng.bakery.improve.business.model.entity.toDto
import com.rafeng.bakery.improve.business.repository.spring.WorkerEntityRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class WorkerService(
    private val workerEntityRepository: WorkerEntityRepository
) {
    private val log = LoggerFactory.getLogger(WorkerService::class.java)

    fun save(dto: Worker): Worker {
        log.debug("Save a new worker")
        return workerEntityRepository.save(dto.toEntity()).toDto()
    }

    fun get(): List<Worker> {
        log.debug("Get all workers")
        return workerEntityRepository.findAll().map { it.toDto() }
    }

    fun delete(id: Long): List<Worker> {
        log.debug("Delete a worker with an Id $id ")
        workerEntityRepository.deleteById(id)
        return workerEntityRepository.findAll().map { it.toDto() }
    }

}