package com.rafeng.bakery.improve.business.service

import org.springframework.data.repository.CrudRepository

interface DefaultEntityRepository<T> : CrudRepository<T, Long> {
}