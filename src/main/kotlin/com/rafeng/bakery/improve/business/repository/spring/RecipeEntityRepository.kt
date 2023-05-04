package com.rafeng.bakery.improve.business.repository.spring

import com.rafeng.bakery.improve.business.model.entity.RecipeEntity
import org.springframework.data.repository.CrudRepository

interface RecipeEntityRepository : CrudRepository<RecipeEntity, Long>