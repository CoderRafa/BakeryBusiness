package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.model.TasteType
import com.rafeng.bakery.improve.business.model.Topping
import com.rafeng.bakery.improve.business.model.ToppingType
import jakarta.persistence.*

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
    lateinit var toppingType: ToppingType

    @Enumerated(EnumType.STRING)
    @Column(name = "tasteType", nullable = false)
    lateinit var tasteType: TasteType

    @ManyToMany(mappedBy = "toppings", fetch = FetchType.LAZY)
    lateinit var itemToppings: List<ItemToppingEntity>
}

fun ToppingEntity.toDto() = Topping(id, name, description, toppingType, tasteType)