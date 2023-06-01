package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Ingredient
import com.rafeng.bakery.improve.business.model.dto.toEntity
import com.rafeng.bakery.improve.business.model.entity.toDto
import com.rafeng.bakery.improve.business.repository.spring.IngredientRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class IngredientService(
    val ingredientRepository: IngredientRepository
) {
    private val log = LoggerFactory.getLogger(IngredientService::class.java)
    fun save(dto: Ingredient) : Ingredient {
        log.debug("Save an ingredient")
        return ingredientRepository.save(dto.toEntity()).toDto()
    }

    fun getAll() : List<Ingredient> {
        log.debug("Get all ingredients")
        return ingredientRepository.findAll().map { it.toDto() }
    }

    fun delete(id: Long): List<Ingredient> {
        log.debug("Delete an ingredient with an Id $id")
        ingredientRepository.deleteById(id)
        return ingredientRepository.findAll().map { it.toDto() }
    }
}