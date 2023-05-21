package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.model.Filling
import jakarta.persistence.*
import com.rafeng.bakery.improve.business.model.ItemFilling as ItemFilling1

@Entity
@Table(name = "itemFilling")
class ItemFillingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "weight", nullable = false)
    var weight: Double = 0.0

    @Column(name = "ratio", nullable = false)
    var ratio: Float = 0f

    @Column(name = "description", nullable = false)
    lateinit var description: String

    @OneToMany(mappedBy = "filling")
    private List<Filling> fillings

    @Entity
    @Table(name = "filling")
    class Filling {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        private val id: Long? = null

        @ManyToOne
        private fillings: ItemFillingEntity
    }

    @ElementCollection
    private listFilling: List<Filling> = listOf()

    @Column(name = "filling", nullable = false)
    lateinit var filling: MutableList<Filling>
}