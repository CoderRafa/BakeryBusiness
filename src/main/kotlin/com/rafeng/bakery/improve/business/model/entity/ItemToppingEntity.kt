package com.rafeng.bakery.improve.business.model.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.SequenceGenerator

@Entity(name = "item_topping")
class ItemToppingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_topping_sequence")
    @SequenceGenerator(name = "item_topping_sequence", allocationSize = 10)
    @Column(name = "id", nullable = false)
    val id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "weight", nullable = false)
    var weight: Double = 0.0

    @Column(name = "ratio", nullable = false)
    var ratio: Float = -1F

    @Column(name = "description", nullable = false)
    lateinit var description: String

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "itemToppings")
    lateinit var toppings: List<ToppingEntity>

}
