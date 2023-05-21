package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.model.TasteType
import com.rafeng.bakery.improve.business.model.ToppingType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "topping")
class ToppingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topping_sequence")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "description", nullable = false)
    lateinit var description: String

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    lateinit var type: ToppingType

    @Enumerated(EnumType.STRING)
    @Column(name = "tasteType", nullable = false)
    lateinit var tasteType: TasteType
}