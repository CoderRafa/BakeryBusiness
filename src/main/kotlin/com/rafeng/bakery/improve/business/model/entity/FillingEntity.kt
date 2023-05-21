package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.model.Filling
import com.rafeng.bakery.improve.business.model.FillingType
import com.rafeng.bakery.improve.business.model.TasteType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity(name = "filling")
class FillingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filling_sequence")
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "description", nullable = false)
    lateinit var description: String

    @Enumerated(EnumType.STRING)
    @Column(name = "filling_type", nullable = false)
    lateinit var fillingType: FillingType

    @Enumerated(EnumType.STRING)
    @Column(name = "taste_type", nullable = false)
    lateinit var tasteType: TasteType

    @ManyToMany(mappedBy = "fillings", fetch = FetchType.LAZY)
    lateinit var itemFillings: List<ItemFillingEntity>
}

fun FillingEntity.toDto() = Filling(id, name, description, fillingType, tasteType)