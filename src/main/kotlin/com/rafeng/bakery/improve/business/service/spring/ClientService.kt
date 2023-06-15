package com.rafeng.bakery.improve.business.service.spring

import com.rafeng.bakery.improve.business.model.Client
import com.rafeng.bakery.improve.business.model.entity.toDto
import com.rafeng.bakery.improve.business.model.toEntity
import com.rafeng.bakery.improve.business.repository.spring.ClientEntityRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientEntityRepository: ClientEntityRepository
) {
    private val log = LoggerFactory.getLogger(ClientService::class.java)

    fun save(dto: Client): Client {
        log.debug("Save new client")
        return clientEntityRepository.save(dto.toEntity()).toDto()
    }

    fun get(): List<Client> {
        log.debug("Get all clients")
        return clientEntityRepository.findAll().map { it.toDto() }
    }

    fun delete(id: Long): List<Client> {
        log.debug("Delete client with ID $id")
        clientEntityRepository.deleteById(id)
        return clientEntityRepository.findAll().map { it.toDto() }
    }
}