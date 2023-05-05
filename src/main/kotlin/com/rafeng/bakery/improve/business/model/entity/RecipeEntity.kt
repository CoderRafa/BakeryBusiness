package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.model.dto.Recipe
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "recipe")
class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "description", nullable = false)
    lateinit var description: String

    @Column(name = "expiration_period", nullable = false)
    var expirationPeriod: Int = 0

    @Column(name = "cooking_time", nullable = false)
    var cookingTime: Double = 0.0
}

fun RecipeEntity.toDto() = Recipe(id, name, description, expirationPeriod, cookingTime)