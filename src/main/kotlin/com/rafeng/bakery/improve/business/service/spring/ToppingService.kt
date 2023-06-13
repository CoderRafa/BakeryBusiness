package com.rafeng.bakery.improve.business.service.spring

import com.rafeng.bakery.improve.business.model.Topping
import com.rafeng.bakery.improve.business.model.entity.toDto
import com.rafeng.bakery.improve.business.model.toEntity
import com.rafeng.bakery.improve.business.notification.publisher.EventPublisher
import com.rafeng.bakery.improve.business.notification.topping.event.CreateToppingEvent
import com.rafeng.bakery.improve.business.notification.topping.event.DeleteToppingEvent
import com.rafeng.bakery.improve.business.notification.topping.event.GetAllToppingsEvent
import com.rafeng.bakery.improve.business.repository.spring.ToppingEntityRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ToppingService(
        private val toppingEntityRepository: ToppingEntityRepository,
        private val eventPublisher: EventPublisher
) {
    private val log = LoggerFactory.getLogger(ToppingService::class.java)

    fun save(dto: Topping): Topping {
        log.debug("Add a new topping")
        return toppingEntityRepository.save(dto.toEntity()).toDto().also {
            if(it.id != null)
                eventPublisher.publishEvent(CreateToppingEvent(dto, "New topping was added"))
        }

    }

    fun get(): List<Topping> {
        log.debug("Get all toppings")
        return toppingEntityRepository.findAll().map { it.toDto() }.also { toppings ->
            if(toppings.isNotEmpty())
                eventPublisher.publishEvent(GetAllToppingsEvent(toppings.map { it.id!! }, "Got all toppings"))
        }
    }

    fun delete(id: Long): List<Topping> {
        log.debug("Delete a topping with an Id $id")
        toppingEntityRepository.deleteById(id)
        return toppingEntityRepository.findAll().map { it.toDto() }.also { toppings ->
            if(toppings.none { it.id == id })
                eventPublisher.publishEvent(DeleteToppingEvent(id, "A topping with an Id $id was deleted"))
        }
    }

}