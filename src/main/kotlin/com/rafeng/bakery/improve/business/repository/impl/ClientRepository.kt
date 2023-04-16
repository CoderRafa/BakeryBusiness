package com.rafeng.bakery.improve.business.repository.impl

import com.rafeng.bakery.improve.business.model.Client
import org.springframework.stereotype.Component

@Component
data class ClientRepository (
    private val client: MutableSet<Client> = mutableSetOf()
): DefaultRepositoryImpl<Client>(client)