package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.generic.EntityTransform
import com.rafeng.bakery.improve.business.model.Client
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "client")
class ClientEntity : EntityTransform<Client> {
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
    override fun toDto(): Client {
        TODO("Not yet implemented")
    }
}