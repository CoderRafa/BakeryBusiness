package com.rafeng.bakery.improve.business.generic

import com.rafeng.bakery.improve.business.model.Client
import com.rafeng.bakery.improve.business.model.entity.ClientEntity
import org.slf4j.LoggerFactory
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

interface BakeryGeneralService<Entity : EntityTransform<DTO>, DTO : DtoTransformer<Entity>> {
    fun save(dto: DTO): DTO

    fun findById(id: Long): DTO
    fun findAll(): List<DTO>

    fun deleteById(id: Long)
}

abstract class DefaultBakeryGeneralService<Entity : EntityTransform<DTO>, DTO : DtoTransformer<Entity>>(
    open val repository: CrudRepository<Entity, Long>
) : BakeryGeneralService<Entity, DTO> {
    private val log = LoggerFactory.getLogger(DefaultBakeryGeneralService::class.java)
    override fun save(dto: DTO): DTO {
        log.debug("Save entity with data: $dto")
        return repository.save(dto.toEntity()).toDto()
    }

    override fun findById(id: Long): DTO {
        log.debug("Find an entity by id: $id")
        return repository
            .findById(id)
            .map { it.toDto() }
            .orElseThrow {
                log.debug("Element with id: $id is not found")
                NoSuchElementException("Element with id: $id is not found")
            }
    }

    override fun findAll(): List<DTO> {
        log.debug("Find all elements")
        return repository.findAll().map { it.toDto() }
    }

    override fun deleteById(id: Long) {
        log.debug("Delete an entity by id: $id")
        return repository.deleteById(id)
    }
}

interface EntityTransform<DTO> {
    fun toDto(): DTO
}

interface DtoTransformer<Entity> {
    fun toEntity(): Entity
}

interface ClientSpringRepository : CrudRepository<ClientEntity, Long>

@Service
class ClientGeneralServiceImpl(val clientRepository: ClientSpringRepository) :
    DefaultBakeryGeneralService<ClientEntity, Client>(clientRepository)