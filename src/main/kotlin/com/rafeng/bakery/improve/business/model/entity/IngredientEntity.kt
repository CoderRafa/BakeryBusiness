package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.model.dto.Ingredient
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "ingredient")
class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_sequence")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "description", nullable = false)
    lateinit var description: String

    @Column(name = "production_date", nullable = false)
    lateinit var productionDate: String

    @Column(name = "expiration_date", nullable = false)
    lateinit var expirationDate: String
}

fun IngredientEntity.toDto() = Ingredient(id, name, description, productionDate, expirationDate)