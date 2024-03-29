package com.rafeng.bakery.improve.business.model.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity(name = "item_filling")
class ItemFillingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_filling_sequence")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "wight", nullable = false)
    var weight: Double = 0.0

    @Column(name = "ratio", nullable = false)
    var ratio: Float = -1F

    @Column(name = "desctiption")
    lateinit var description: String


    @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "itemFillings", fetch = FetchType.LAZY)
    lateinit var fillings: List<FillingEntity>
}