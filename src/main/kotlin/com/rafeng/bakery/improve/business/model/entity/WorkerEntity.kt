package com.rafeng.bakery.improve.business.model.entity

import com.rafeng.bakery.improve.business.model.dto.Position
import com.rafeng.bakery.improve.business.model.dto.Worker
import jakarta.persistence.*

@Entity
@Table(name = "worker")
class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "lastname", nullable = false)
    lateinit var lastname: String

    @Column(name = "position", nullable = false)
    lateinit var position: Position
}

fun WorkerEntity.toDto() = Worker(id, name, lastname, position)