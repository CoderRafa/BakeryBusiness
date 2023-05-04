package com.rafeng.bakery.improve.business.model.entity

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
    var name: String? = null

    @Column(name = "description", nullable = false)
    var description: String? = null

    @Column(name = "expiration_period", nullable = false)
    var expirationPeriod: Int? = null

    @Column(name = "cooking_time", nullable = false)
    var cookingTime: Double? = null
}