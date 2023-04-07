package com.rafeng.bakery.improve.business.repository

interface DefaultRepository<T> {
    fun save(item: T): Boolean

    fun delete(item: T): Boolean

    fun getAll(): Iterable<T>
}