package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.model.Topping
import jakarta.persistence.*

@Entity(name = "item_topping")
class ItemToppingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_topping_sequence")
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "item_topping_to_topping",
            joinColumns = [JoinColumn(name = "item_topping_id")],
            inverseJoinColumns = [JoinColumn(name = "topping_id")]
    )
    lateinit var toppings: List<ToppingEntity>

}
