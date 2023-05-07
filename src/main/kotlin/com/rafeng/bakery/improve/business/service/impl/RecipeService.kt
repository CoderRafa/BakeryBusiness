package com.rafeng.bakery.improve.business.service.impl

import com.rafeng.bakery.improve.business.model.dto.Recipe
import com.rafeng.bakery.improve.business.model.dto.toEntity
import com.rafeng.bakery.improve.business.model.entity.toDto
import com.rafeng.bakery.improve.business.repository.spring.RecipeEntityRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class RecipeService(private val recipeEntityRepository: RecipeEntityRepository) {
    private val log = LoggerFactory.getLogger(RecipeService::class.java)
    fun save(dto: Recipe): Recipe {
        log.debug("Save new recipe")
        return recipeEntityRepository.save(dto.toEntity()).toDto()
    }
}