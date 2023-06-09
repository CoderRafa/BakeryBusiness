package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.IngredientEntity
import org.springframework.data.repository.CrudRepository

interface IngredientRepository : CrudRepository<IngredientEntity, Long>