package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.model.Client
import jakarta.persistence.*

@Entity
@Table(name = "client")
class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "lastname", nullable = false)
    lateinit var lastname: String

    @Column(name = "phoneNumber", nullable = false)
    lateinit var phoneNumber: String
}

fun ClientEntity.toDto() = Client(id, name, lastname, phoneNumber)