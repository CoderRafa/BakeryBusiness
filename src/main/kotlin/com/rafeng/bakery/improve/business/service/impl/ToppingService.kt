package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.Topping
import com.rafeng.bakery.improve.business.model.entity.toDto
import com.rafeng.bakery.improve.business.model.toEntity
import com.rafeng.bakery.improve.business.repository.spring.ToppingEntityRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ToppingService(
        private val toppingEntityRepository: ToppingEntityRepository
) {
    private val log=LoggerFactory.getLogger(ToppingService::class.java)

    fun save(dto: Topping): Topping {
        log.debug("Add a new topping")
        return toppingEntityRepository.save(dto.toEntity()).toDto()
    }

    fun get(): List<Topping> {
        log.debug("Get all toppings")
        return toppingEntityRepository.findAll().map { it.toDto() }
    }

    fun delete(id: Long): List<Topping> {
        log.debug("Delete a topping with an Id $id")
        toppingEntityRepository.deleteById(id)
        return toppingEntityRepository.findAll().map { it.toDto() }
    }

}