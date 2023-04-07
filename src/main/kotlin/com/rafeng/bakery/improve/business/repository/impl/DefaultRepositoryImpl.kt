package com.rafeng.bakery.improve.business.repository.impl

import com.rafeng.bakery.improve.business.repository.DefaultRepository

abstract class DefaultRepositoryImpl<T>(open val accumulator: MutableCollection<T>) : DefaultRepository<T> {
    override fun save(item: T): Boolean = accumulator.add(item)

    override fun delete(item: T): Boolean = accumulator.remove(item)

    override fun getAll(): Collection<T> = accumulator
}