package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Filling
import com.rafeng.bakery.improve.business.model.entity.toDto
import com.rafeng.bakery.improve.business.model.toEntity
import com.rafeng.bakery.improve.business.notification.event.CreateFillingEvent
import com.rafeng.bakery.improve.business.notification.publisher.EventPublisher
import com.rafeng.bakery.improve.business.repository.spring.FillingEntityRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class FillingService(
    private val fillingEntityRepository: FillingEntityRepository,
    private val eventPublisher: EventPublisher
) {
    private val log = LoggerFactory.getLogger(FillingService::class.java)

    fun save(dto: Filling): Filling {
        log.debug("Save a new filling")

        return fillingEntityRepository.save(dto.toEntity()).toDto().also {
            if (it.id != null)
                eventPublisher.publishEvent(CreateFillingEvent(dto, "New filling added"))
        }
    }

    fun get(): List<Filling> {
        log.debug("Get all fillings")
        return fillingEntityRepository.findAll().map { it.toDto() }
    }

    fun delete(id: Long): List<Filling> {
        log.debug("Delete a filling with an Id $id")
        fillingEntityRepository.deleteById(id)
        return fillingEntityRepository.findAll().map { it.toDto() }
    }
}